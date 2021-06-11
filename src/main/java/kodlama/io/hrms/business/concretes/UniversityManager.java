package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UniversityService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.UniversityDao;
import kodlama.io.hrms.entities.concretes.University;
@Service
public class UniversityManager implements UniversityService {
	private UniversityDao universityDao;

	@Autowired
	public UniversityManager(UniversityDao universityDao) {
		super();
		this.universityDao = universityDao;
	}

	@Override
	public Result add(University university) {
		this.universityDao.save(university);
		return new SuccessResult(Messages.dataAdded);

	}

	@Override
	public DataResult<List<University>> getAll() {
		return new SuccessDataResult<List<University>>(this.universityDao.findAll(),Messages.DataListed);
	}

	@Override
	public DataResult<University> getById(int id) {
		return new SuccessDataResult<University>(this.universityDao.findById(id));
		//return new SuccessDataResult<University>(this.universityDao.findById(id),Messages.DataListed);
	}
}
