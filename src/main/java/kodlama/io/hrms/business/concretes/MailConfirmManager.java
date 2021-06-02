package kodlama.io.hrms.business.concretes;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.MailConfirmService;
import kodlama.io.hrms.core.utilities.helpers.Generators.RandomStringGenerator;
import kodlama.io.hrms.core.utilities.helpers.MailHelper.FakeMailSender;
import kodlama.io.hrms.core.utilities.helpers.MailHelper.MailService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
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
	public Result ConfirmEmail(MailVeritification veritification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result isConfirmed(String email,int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result addCode(User user) {
	String code=RandomStringGenerator.Generate(5);
	LocalDateTime date=LocalDateTime.now().plusDays(1);
	String text="Üyeliğinizi aktifleştirmek için "+date+" Tarihine kadar "+code+" Kodunu giriniz";
	MailVeritification mailVeritification=new MailVeritification(0,user.getId(),user.getEmailAdress(),code,date, false);
	mailVeritificationDao.save(mailVeritification);
	//mailService.sendMail(user.getEmailAdress(),text);
	return new SuccessResult("Kod üretildi "+user.getEmailAdress()+" mail gönderildi");
	}



}
