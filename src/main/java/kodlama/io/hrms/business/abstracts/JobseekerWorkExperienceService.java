package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobseekerWorkExperience;

public interface JobseekerWorkExperienceService {
	 DataResult<List<JobseekerWorkExperience>> getAll();
	Result add(JobseekerWorkExperience jobseekerWorkExperience);

}
