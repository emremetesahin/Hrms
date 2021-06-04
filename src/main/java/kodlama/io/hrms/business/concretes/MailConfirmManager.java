package kodlama.io.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.MailConfirmService;
import kodlama.io.hrms.core.utilities.helpers.Generators.RandomStringGenerator;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.rules.BusinessRules;
import kodlama.io.hrms.dataAccess.abstracts.MailVeritificationDao;
import kodlama.io.hrms.entities.concretes.MailVeritification;
import kodlama.io.hrms.entities.concretes.User;

@Service
public class MailConfirmManager implements MailConfirmService {
	private MailVeritificationDao mailVeritificationDao;

	@Autowired
	public MailConfirmManager(MailVeritificationDao mailVeritificationDao) {
		this.mailVeritificationDao = mailVeritificationDao;
	}

	@Override
	public Result ConfirmEmail(int userId,String email,String code) {
		var user=this.mailVeritificationDao.getByUserIdAndEmail(userId, email);
		if(user==null)
		{
			return new ErrorResult("İlgili kullanıcıya ulaşılamadı");
		}
		var result=BusinessRules.Run(checkCodeNotExpired(user.getCodeExpirationDate()),checkCodeisCorrect(code,user.getCode()));
		if(result==null)
		{
			if(user.isConfirmed())
			{
				return new ErrorResult("Mail zaten doğrulandı");
			}
			else
			{
			user.setConfirmed(true);
			this.mailVeritificationDao.save(user);
			return new SuccessResult("Mail kaydı onaylandı");
			}
		}
		else
		{
			
			return result;
		}
	}

	@Override
	public DataResult<Boolean> isConfirmed(String email,int userId) {
		var result=this.mailVeritificationDao.getByUserIdAndEmail(userId, email);
		if(result==null)
		{
			return new ErrorDataResult<Boolean>("İlgili kullanıcıya ulaşılamadı");
		}
			if(result.isConfirmed())
			{
				return new SuccessDataResult<Boolean>(true,"İlgili kullanıcının maili onaylanmış");
			}
			else
			{
				return new ErrorDataResult<Boolean>(false,"İlgili kullanıcının maili onaylanmamış");
			}
	}

	@Override
	public Result addCode(User user) {
	String code=RandomStringGenerator.Generate(5);
	LocalDateTime date=LocalDateTime.now().plusDays(1);
	String text="Üyeliğinizi aktifleştirmek için "+date+" Tarihine kadar "+code+" Kodunu giriniz";
	MailVeritification mailVeritification=new MailVeritification(user.getId(),user.getId(),user.getEmailAdress(),code,date, false);
	mailVeritificationDao.save(mailVeritification);
	//mailService.sendMail(user.getEmailAdress(),text);
	return new SuccessResult("Kod üretildi "+user.getEmailAdress()+" mail gönderildi");
	}

	@Override
	public DataResult<List<MailVeritification>> getAll() {
		return new SuccessDataResult<List<MailVeritification>>(mailVeritificationDao.findAll(),"Data Listelendi");
	}

//BusinessRules
	public Result checkCodeNotExpired(LocalDateTime expirationDate)
	{
		if(expirationDate.isBefore(LocalDateTime.now()))
		{
			return new SuccessResult();
		}
		else
		{
			return new ErrorResult("Doğrulama kodunun süresi doldu.");
		}
	}
	public Result checkCodeisCorrect(String entredCode,String correctCode)
	{
		if(entredCode.equals(correctCode))
		{
			return new SuccessResult();
		}
		else
		{
			return new ErrorResult("Doğrulama kodu yanlış");
		}
	}

}
