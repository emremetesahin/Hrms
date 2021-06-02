package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.AuthService;
import kodlama.io.hrms.business.abstracts.JobseekerService;
import kodlama.io.hrms.business.abstracts.MailConfirmService;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.business.adapters.abstracts.UserCheckService;
import kodlama.io.hrms.business.adapters.concretes.FakeMerniseServiceAdapter;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.rules.BusinessRules;
import kodlama.io.hrms.entities.concretes.Jobseeker;
import kodlama.io.hrms.entities.concretes.User;

@Service
public class AuthManager implements AuthService {
	private JobseekerService jobseekerService;
	private UserCheckService userCheckService;
	private UserService userService;
	private MailConfirmService mailConfirmService;

	@Autowired
	public AuthManager(JobseekerService jobseekerService, UserService userService,MailConfirmService mailConfirmService) {
		this.jobseekerService = jobseekerService;
		this.userCheckService = new FakeMerniseServiceAdapter();
		this.userService = userService;
		this.mailConfirmService=mailConfirmService;
	}

	@Override
	public Result register(Jobseeker jobseeker) {

		Result result = BusinessRules.Run(userCheckService.checkIfRealPerson(jobseeker), isExistsEmail(jobseeker),
				isExistsNationalityId(jobseeker));
		if (result == null) {
			//this.mailConfirmService.addCode(jobseeker);
			this.jobseekerService.add(jobseeker);
			System.out.println(jobseeker);
			
			return new SuccessResult("Sisteme kayıt başarılı. Lütfen e postanızı doğrulayın");
		} else {
			return result;
		}
	}

	// BusinessRules
	public Result isExistsEmail(User user) {
		var result = this.userService.existsByEmailAdress(user);
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

}