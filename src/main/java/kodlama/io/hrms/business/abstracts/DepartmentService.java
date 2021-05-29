package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.DataResult;
import kodlama.io.hrms.core.utilities.Result;
import kodlama.io.hrms.entities.concretes.Department;

public interface DepartmentService {
	DataResult<List<Department>>getAll();
	Result add(Department department);
}
