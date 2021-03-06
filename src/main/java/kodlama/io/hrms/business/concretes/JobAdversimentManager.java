package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdversimentService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdversimentDao;
import kodlama.io.hrms.entities.concretes.JobAdversiment;
import kodlama.io.hrms.entities.concretes.dtos.JobAdversimentDetailDto;

@Service
public class JobAdversimentManager implements JobAdversimentService {
	private JobAdversimentDao jobAdversimentDao;

	@Autowired
	public JobAdversimentManager(JobAdversimentDao jobAdversimentDao) {
		this.jobAdversimentDao = jobAdversimentDao;
	}

	@Override
	public Result add(JobAdversiment jobAdversiment) {
		this.jobAdversimentDao.save(jobAdversiment);
		return new SuccessResult("Data Eklendi");
	}

	@Override
	public DataResult<List<JobAdversimentDetailDto>> getActiveAndCanBeAppliedTrue() {
		return new SuccessDataResult<List<JobAdversimentDetailDto>>(
				this.jobAdversimentDao.findByActiveAndCanBeAppliedTrue(), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdversimentDetailDto>> getActiveAndCanBeAppliedTrueOrderByDate() {
		return new SuccessDataResult<List<JobAdversimentDetailDto>>(
				this.jobAdversimentDao.findByActiveAndCanBeAppliedTrueOrderByDate(), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdversimentDetailDto>> getByEmployerIdAndActiveAndCanBeAppliedTrue(int employerId) {
		return new SuccessDataResult<List<JobAdversimentDetailDto>>(jobAdversimentDao.findByActiveTrueAndCanBeAppliedTrueAndEmployerId(employerId),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdversiment>> getAll() {
		return new SuccessDataResult<List<JobAdversiment>>(jobAdversimentDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result closeTheAd(int adId) {
		var ad=this.jobAdversimentDao.getOne(adId);
		ad.setCanBeApplied(false);
		this.jobAdversimentDao.save(ad);
		return new SuccessResult("??lan ba??vuruya kapat??ld??");
		
	}

	@Override
	public Result openTheAd(int adId) {
		var ad=this.jobAdversimentDao.getOne(adId);
		ad.setCanBeApplied(true);
		this.jobAdversimentDao.save(ad);
		return new SuccessResult("??lan ba??vuruya a????ld??");
		
	}
}
