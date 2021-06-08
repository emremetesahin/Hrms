package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobseekerEducationInformation;

public interface JobseekerEducationInformationService {
	Result add(JobseekerEducationInformation jobseekerEducationInformation);
	DataResult<List<JobseekerEducationInformation>>getAll();

}
