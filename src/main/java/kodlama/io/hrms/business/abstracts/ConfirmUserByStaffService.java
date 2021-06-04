package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.ConfirmUserByStaff;
import kodlama.io.hrms.entities.concretes.User;

public interface ConfirmUserByStaffService {
	public Result Confirm(ConfirmUserByStaff confirmUserByStaff);
	DataResult<List<ConfirmUserByStaff>> getAll();
}
