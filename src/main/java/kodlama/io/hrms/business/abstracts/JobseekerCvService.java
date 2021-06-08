package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobseekerCv;

public interface JobseekerCvService {
	Result add(JobseekerCv jobseekerCv);
	DataResult<List<JobseekerCv>>getAll();

}
