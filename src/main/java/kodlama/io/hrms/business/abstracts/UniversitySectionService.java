package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.UniversitySection;

public interface UniversitySectionService {
	Result add(UniversitySection universitySection);
	DataResult<List<UniversitySection>>getAll();

}
