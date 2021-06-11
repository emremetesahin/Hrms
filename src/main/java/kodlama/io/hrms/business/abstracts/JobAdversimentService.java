package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdversiment;
import kodlama.io.hrms.entities.concretes.dtos.JobAdversimentDetailDto;
import kodlama.io.hrms.entities.concretes.dtos.JobseekerWithVeritificationsDto;

public interface JobAdversimentService {
	Result add(JobAdversiment jobAdversiment);
	DataResult<List<JobAdversimentDetailDto>> getActiveAndCanBeAppliedTrue();
	DataResult<List<JobAdversimentDetailDto>> getActiveAndCanBeAppliedTrueOrderByDate();
	DataResult<List<JobAdversimentDetailDto>> getByEmployerIdAndActiveAndCanBeAppliedTrue(int employerId);
	DataResult<List<JobAdversiment>> getAll();
	Result closeTheAd(int adId);
	Result openTheAd(int adId);
}
