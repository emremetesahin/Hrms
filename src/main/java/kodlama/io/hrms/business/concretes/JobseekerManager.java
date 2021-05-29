package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.utilities.DataResult;
import kodlama.io.hrms.core.utilities.Result;
import kodlama.io.hrms.core.utilities.SuccessDataResult;
import kodlama.io.hrms.core.utilities.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobseekerDao;
import kodlama.io.hrms.entities.concretes.Jobseeker;

@Service
public class JobseekerManager implements JobSeekerService{
	private JobseekerDao jobseekerDao;
	
	@Autowired
	public JobseekerManager(JobseekerDao jobseekerDao) {
		this.jobseekerDao = jobseekerDao;
	}

	@Override
	public DataResult<List<Jobseeker>> getAll() {
		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.findAll(),"İş arayanlar Listelendi");
	}

	@Override
	public Result add(Jobseeker jobSeeker) {
		this.jobseekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan eklendi");
	}
	
}
