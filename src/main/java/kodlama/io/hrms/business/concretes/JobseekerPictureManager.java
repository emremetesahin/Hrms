package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobseekerPictureService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobseekerPictureDao;
import kodlama.io.hrms.entities.concretes.JobseekerPicture;
@Service
public class JobseekerPictureManager implements JobseekerPictureService {
	private JobseekerPictureDao jobseekerPictureDao;

	@Autowired
	public JobseekerPictureManager(JobseekerPictureDao jobseekerPictureDao) {
		this.jobseekerPictureDao = jobseekerPictureDao;
	}

	@Override
	public Result add(JobseekerPicture jobseekerPicture) {
		this.jobseekerPictureDao.save(jobseekerPicture);
		return new SuccessResult(Messages.dataAdded);

	}

	@Override
	public DataResult<List<JobseekerPicture>> getAll() {
		return new SuccessDataResult<List<JobseekerPicture>>(this.jobseekerPictureDao.findAll(),Messages.DataListed);
	}
}
