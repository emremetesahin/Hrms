package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobseekerEducationInformationService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobseekerEducationInformationDao;
import kodlama.io.hrms.entities.concretes.JobseekerEducationInformation;
@Service
public class JobseekerEducationInformationManager implements JobseekerEducationInformationService{
	private JobseekerEducationInformationDao jobseekerEducationInformationDao;

	@Autowired
	public JobseekerEducationInformationManager(JobseekerEducationInformationDao jobseekerEducationInformationDao) {
		this.jobseekerEducationInformationDao = jobseekerEducationInformationDao;
	}

	@Override
	public Result add(JobseekerEducationInformation jobseekerEducationInformation) {
		this.jobseekerEducationInformationDao.save(jobseekerEducationInformation);
		return new SuccessResult(Messages.dataAdded);

	}

	@Override
	public DataResult<List<JobseekerEducationInformation>> getAll() {
		return new SuccessDataResult<List<JobseekerEducationInformation>>(jobseekerEducationInformationDao.findAll(),Messages.DataListed);
	}

}
