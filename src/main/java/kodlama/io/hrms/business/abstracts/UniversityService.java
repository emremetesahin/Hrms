package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.University;

public interface UniversityService {
	Result add(University university);
	DataResult<List<University>>getAll();
	DataResult<University>getById(int id);

}
