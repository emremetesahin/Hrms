package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.DataResult;
import kodlama.io.hrms.core.utilities.Result;
import kodlama.io.hrms.entities.concretes.Employer;

public interface EmployerService {
	 DataResult<List<Employer>> getAll();
	Result add(Employer employer);

}
