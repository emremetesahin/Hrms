package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.DataResult;
import kodlama.io.hrms.core.utilities.Result;
import kodlama.io.hrms.entities.concretes.Jobseeker;

public interface JobSeekerService {
	 DataResult<List<Jobseeker>> getAll();
	Result add(Jobseeker jobSeeker);

}
