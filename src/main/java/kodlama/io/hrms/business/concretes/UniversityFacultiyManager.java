package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UniversityFacultyService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.UniversityFacultyDao;
import kodlama.io.hrms.entities.concretes.UniversityFaculty;

@Service
public class UniversityFacultiyManager implements UniversityFacultyService {
	private UniversityFacultyDao universityFacultyDao;

	@Autowired
	public UniversityFacultiyManager(UniversityFacultyDao universityFacultyDao) {
		this.universityFacultyDao = universityFacultyDao;
	}

	@Override
	public Result add(UniversityFaculty universiteFacultiy) {
		 this.universityFacultyDao.save(universiteFacultiy);
		return new SuccessResult(Messages.dataAdded);

	}

	@Override
	public DataResult<List<UniversityFaculty>> getAll() {
		return new SuccessDataResult<List<UniversityFaculty>>(this.universityFacultyDao.findAll(),Messages.DataListed);
	}
}
