package kodlama.io.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ConfirmUserByStaffService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ConfirmUserByStaffDao;
import kodlama.io.hrms.entities.concretes.ConfirmUserByStaff;
@Service
public class ConfirmUserByStaffManager implements ConfirmUserByStaffService {
	private ConfirmUserByStaffDao confirmUserByStaffDao;

	@Autowired
	public ConfirmUserByStaffManager(ConfirmUserByStaffDao confirmUserByStaffDao) {
		this.confirmUserByStaffDao = confirmUserByStaffDao;
	}

	@Override
	public Result Confirm(ConfirmUserByStaff confirmUserByStaff) {
		confirmUserByStaff.setIsConfirmed(true);
		confirmUserByStaff.setConfirmDate(LocalDateTime.now());
		this.confirmUserByStaffDao.save(confirmUserByStaff);
		return new SuccessResult("Üyelik onaylandı");
	}

	@Override
	public DataResult<List<ConfirmUserByStaff>> getAll() {
		return new SuccessDataResult<List<ConfirmUserByStaff>>(this.confirmUserByStaffDao.findAll(),"Data Listelendi");
	}

}
