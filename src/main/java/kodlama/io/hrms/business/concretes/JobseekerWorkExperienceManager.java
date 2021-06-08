package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobseekerWorkExperienceService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobseekerWorkExperienceDao;
import kodlama.io.hrms.entities.concretes.JobseekerWorkExperience;

@Service
public class JobseekerWorkExperienceManager implements JobseekerWorkExperienceService {
	private JobseekerWorkExperienceDao jobseekerWorkExperienceDao;

	@Autowired
	public JobseekerWorkExperienceManager(JobseekerWorkExperienceDao jobseekerWorkExperienceDao) {
		this.jobseekerWorkExperienceDao = jobseekerWorkExperienceDao;
	}

	@Override
	public DataResult<List<JobseekerWorkExperience>> getAll() {
	return new SuccessDataResult<List<JobseekerWorkExperience>>(this.jobseekerWorkExperienceDao.findAll(),Messages.DataListed);
	}

	@Override
	public Result add(JobseekerWorkExperience jobseekerWorkExperience) {
		this.jobseekerWorkExperienceDao.save(jobseekerWorkExperience);
		return new SuccessResult(Messages.dataAdded);
	}

}
