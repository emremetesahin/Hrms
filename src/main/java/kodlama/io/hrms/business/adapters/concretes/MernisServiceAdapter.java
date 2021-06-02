package kodlama.io.hrms.business.adapters.concretes;

import java.rmi.RemoteException;
import java.util.Locale;

import kodlama.io.hrms.business.adapters.abstracts.UserCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Jobseeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements UserCheckService {

	@Override
	public Result checkIfRealPerson(Jobseeker jobseeker) {
		boolean result=true;
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		try {
			result=client.TCKimlikNoDogrula(Long.parseLong(jobseeker.getNationalityId()),
					jobseeker.getFirstName().toUpperCase(new Locale("tr")),
					jobseeker.getLastName().toUpperCase(new Locale("tr")),jobseeker.getYearOfBirth());

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result)
		{
			return new SuccessResult();
		}
		else
		{
			return new ErrorResult("Lütfen kimlik bilgilerini doğru giriniz");
		}
		
	}


}