package kodlama.io.hrms.business.adapters.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Jobseeker;

public interface UserCheckService {
	Result checkIfRealPerson(Jobseeker jobseeker);
}
