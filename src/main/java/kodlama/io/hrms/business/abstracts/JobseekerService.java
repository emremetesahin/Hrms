package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Jobseeker;
import kodlama.io.hrms.entities.concretes.dtos.JobseekerWithVeritificationsDto;

public interface JobseekerService {
	 DataResult<List<Jobseeker>> getAll();
	Result add(Jobseeker jobSeeker);
	Result isExistsByNationalityId(Jobseeker jobseeker);
	DataResult<JobseekerWithVeritificationsDto>getVeritificationValue(int userId);


}
