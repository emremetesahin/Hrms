package kodlama.io.hrms.business.adapters.concretes;


import fakeMerniseService.VerifyRealPerson;
import kodlama.io.hrms.business.adapters.abstracts.UserCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Jobseeker;

public class FakeMerniseServiceAdapter implements UserCheckService{

	@Override
	public Result checkIfRealPerson(Jobseeker jobseeker) {
		VerifyRealPerson verifyRealPerson=new VerifyRealPerson();
		boolean result= verifyRealPerson.FakeVeritification(jobseeker.getYearOfBirth());
		if(result)
		{
			return new SuccessResult();
		}
		else
		{
			return new ErrorResult("Kimlik bilgisi Eşleştirilemedi");
		}
		
		
		
	}

}
