package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Jobseeker;

public interface JobseekerService {
	 DataResult<List<Jobseeker>> getAll();
	Result add(Jobseeker jobSeeker);
	Result isExistsByNationalityId(Jobseeker jobseeker);

}
