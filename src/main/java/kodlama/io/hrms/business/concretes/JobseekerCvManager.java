package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobseekerCvService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobseekerCvDao;
import kodlama.io.hrms.entities.concretes.JobseekerCv;
@Service
public class JobseekerCvManager implements JobseekerCvService {
	private JobseekerCvDao jobseekerCvDao;

	@Autowired
	public JobseekerCvManager(JobseekerCvDao jobseekerCvDao) {
		this.jobseekerCvDao = jobseekerCvDao;
	}

	@Override
	public Result add(JobseekerCv jobseekerCv) {
		this.jobseekerCvDao.save(jobseekerCv);
		return new SuccessResult(Messages.dataAdded);

	}

	@Override
	public DataResult<List<JobseekerCv>> getAll() {
		return new SuccessDataResult<List<JobseekerCv>>(jobseekerCvDao.findAll(),Messages.DataListed);
	}

}
