package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobseekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobseekerDao;
import kodlama.io.hrms.entities.concretes.Jobseeker;

@Service
public class JobseekerManager implements JobseekerService{
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

	@Override
	public Result isExistsByNationalityId(Jobseeker jobseeker) {
		var result=this.jobseekerDao.existsByNationalityId(jobseeker.getNationalityId());
		if(result)
		{
			return new SuccessResult("İlgili TC ile kayıtlı üye bulundu");
		}
		else
		{
			return new ErrorResult("İlgili Tc ile Kayıtlı üye yok");
		}
	}

	
}
