package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.Jobseeker;

public interface AuthService {
	Result register(Jobseeker jobseeker);
	Result register(Employer employer);
	Result login(Jobseeker jobseeker);
	Result login(Employer employer);
	
}
