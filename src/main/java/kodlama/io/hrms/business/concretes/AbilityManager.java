package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.AbilityService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.AbilityDao;
import kodlama.io.hrms.entities.concretes.Ability;

@Service
public class AbilityManager implements AbilityService {
	private AbilityDao abilityDao;

	@Autowired
	public AbilityManager(AbilityDao abilityDao) {
		this.abilityDao = abilityDao;
	}

	@Override
	public Result add(Ability abiliyt) {
		this.abilityDao.save(abiliyt);
		return new SuccessResult(Messages.dataAdded);
	}

	@Override
	public DataResult<List<Ability>> getAll() {
		return new SuccessDataResult<List<Ability>>(abilityDao.findAll(), Messages.DataListed);
	}
}
