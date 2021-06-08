package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobseekerAbilityService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobseekerAbilityDao;
import kodlama.io.hrms.entities.concretes.JobseekerAbility;

@Service
public class JobseekerAbilityManager implements JobseekerAbilityService {
	private JobseekerAbilityDao jobseekerAbilityDao;

	@Autowired
	public JobseekerAbilityManager(JobseekerAbilityDao jobseekerAbilityDao) {
		this.jobseekerAbilityDao = jobseekerAbilityDao;
	}

	@Override
	public Result add(JobseekerAbility jobseekerAbility) {
		jobseekerAbilityDao.save(jobseekerAbility);
		return new SuccessResult(Messages.dataAdded);
	}

	@Override
	public DataResult<List<JobseekerAbility>> getAll() {
		return new SuccessDataResult<List<JobseekerAbility>>(jobseekerAbilityDao.findAll(),Messages.DataListed);
	}
}
