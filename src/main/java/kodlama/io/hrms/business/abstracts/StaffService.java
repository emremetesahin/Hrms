package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.DataResult;
import kodlama.io.hrms.core.utilities.Result;
import kodlama.io.hrms.entities.concretes.Staff;

public interface StaffService {
	DataResult<List<Staff>>getAll();
	Result add(Staff staff);
}
