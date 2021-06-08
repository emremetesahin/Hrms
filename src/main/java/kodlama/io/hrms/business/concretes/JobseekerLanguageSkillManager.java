package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobseekerLanguageSkillService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobseekerLanguageSkillDao;
import kodlama.io.hrms.entities.concretes.JobseekerLanguageSkill;
@Service
public class JobseekerLanguageSkillManager implements JobseekerLanguageSkillService {
private JobseekerLanguageSkillDao jobseekerLanguageSkillDao;
@Autowired
	public JobseekerLanguageSkillManager(JobseekerLanguageSkillDao jobseekerLanguageSkillDao) {
	this.jobseekerLanguageSkillDao = jobseekerLanguageSkillDao;
}

	@Override
	public Result add(JobseekerLanguageSkill jobseekerLanguageSkill) {
		this.jobseekerLanguageSkillDao.save(jobseekerLanguageSkill);
		return new SuccessResult(Messages.dataAdded);
	}

	@Override
	public DataResult<List<JobseekerLanguageSkill>> getAll() {
		return new SuccessDataResult<List<JobseekerLanguageSkill>>(this.jobseekerLanguageSkillDao.findAll(),Messages.DataListed);
	}
}
