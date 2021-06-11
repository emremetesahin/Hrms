package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobseekerCv;
import kodlama.io.hrms.entities.concretes.dtos.JobseekerCvAddDto;
import kodlama.io.hrms.entities.concretes.dtos.JobseekerCvDetailsDto;

public interface JobseekerCvService {
	Result add(JobseekerCvAddDto jobseekerCvAddDto);
	DataResult<List<JobseekerCv>>getAll();
	DataResult<List<JobseekerCvDetailsDto>>getCvDetails();
	DataResult<List<JobseekerCvDetailsDto>>getByJobseekerId(int jobseekerId);
}
