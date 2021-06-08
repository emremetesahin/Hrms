package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UniversitySectionService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.UniversitySectionDao;
import kodlama.io.hrms.entities.concretes.UniversitySection;
@Service
public class UniversitySectionManager implements UniversitySectionService{
	private UniversitySectionDao universitySectionDao;

	@Autowired
	public UniversitySectionManager(UniversitySectionDao universitySectionDao) {
		this.universitySectionDao = universitySectionDao;
	}

	@Override
	public Result add(UniversitySection universitySection) {
		this.universitySectionDao.save(universitySection);
		return new SuccessResult(Messages.dataAdded);

	}

	@Override
	public DataResult<List<UniversitySection>> getAll() {
		
		return new SuccessDataResult<List<UniversitySection>>(this.universitySectionDao.findAll(),Messages.DataListed);
	}
}
