package kodlama.io.hrms.business.concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.AuthService;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.JobseekerService;
import kodlama.io.hrms.business.abstracts.MailConfirmService;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.business.adapters.abstracts.UserCheckService;
import kodlama.io.hrms.business.adapters.concretes.FakeMerniseServiceAdapter;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.rules.BusinessRules;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.Jobseeker;

@Service
public class AuthManager implements AuthService {
	private JobseekerService jobseekerService;
	private UserCheckService userCheckService;
	private UserService userService;
	private MailConfirmService mailConfirmService;
	private EmployerService employerService;

	@Autowired
	public AuthManager(JobseekerService jobseekerService, UserService userService,
			MailConfirmService mailConfirmService, EmployerService employerService) {
		this.jobseekerService = jobseekerService;
		this.userCheckService = new FakeMerniseServiceAdapter();
		this.userService = userService;
		this.mailConfirmService = mailConfirmService;
		this.employerService = employerService;
	}

	@Override
	public Result register(Jobseeker jobseeker) {

		Result result = BusinessRules.Run(userCheckService.checkIfRealPerson(jobseeker),
				isExistsEmail(jobseeker.getEmailAdress()), isExistsNationalityId(jobseeker));
		if (result == null) {
			System.out.println(jobseeker);
			this.jobseekerService.add(jobseeker);
			this.mailConfirmService.addCode(jobseeker);
			return new SuccessResult("Sisteme kayıt başarılı. Lütfen e postanızı doğrulayın");
		} else {
			return result;
		}
	}

	@Override
	public Result register(Employer employer) {
		Result result = BusinessRules.Run(
				isExistsEmail(employer.getEmailAdress()),
				isWebSiteDomainIsRegular(employer.getWebAdress()),
				isMailAdressContainsWebSiteDomain(employer.getEmailAdress(),employer.getWebAdress())
				);
		if (result == null) {
			this.employerService.add(employer);
			this.mailConfirmService.addCode(employer);
			return new SuccessResult("İşveren eklendi Lütfen e postanızı kontrol ediniz");
		} else {
			return result;
		}

	}

	// BusinessRules
	public Result isExistsEmail(String email) {
		var result = this.userService.existsByEmailAdress(email);
		if (result.getSuccess()) {
			return new ErrorResult("İlgili e posta sisteme kayıt olmuş");
		} else {
			return new SuccessResult();
		}
	}

	public Result isExistsNationalityId(Jobseeker jobseeker) {
		var result = this.jobseekerService.isExistsByNationalityId(jobseeker);
		if (result.getSuccess()) {
			return new ErrorResult("İlgili Tc kimlik numaralı üye sisteme kayıt olmuş");
		} else {
			return new SuccessResult();
		}
	}

	public Result isWebSiteDomainIsRegular(String email) {
		String regex = "(\\Ahttps?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})";
		var result = Pattern.matches(regex, email);
		if (result) {
			return new SuccessResult();
		} else {
			return new ErrorResult("Geçerli bir web sitesi giriniz");
		}
	}

	public static Result isMailAdressContainsWebSiteDomain(String email, String webSite) {
		var result=email.contains(webSite.substring(5));
		if(result)
		{
			return new SuccessResult();
		}
		else
		{
			return new ErrorResult("Lütfen Web Sitenizdeki domaine ait bir mail hesabı kullanın");
		}
	}

	@Override
	public Result login(Jobseeker jobseeker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result login(Employer employer) {
		// TODO Auto-generated method stub
		return null;
	}
}
