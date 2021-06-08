package kodlama.io.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.DepartmentService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Department;
 
@RestController
@RequestMapping("/api/departments/")
public class DepartmentsController {
	private DepartmentService departmentService;

	@Autowired
	public DepartmentsController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping("getall")
	public DataResult<List<Department>> getAll() {
		return this.departmentService.getAll();
	}
	
	
	@GetMapping("update")
	public Result update(@RequestBody Department department)
	{
		return this.departmentService.update(department);
	}

	
	@PostMapping(value="add")
	public ResponseEntity<Result> add(@Valid @RequestBody Department department)
	{
		return ResponseEntity.ok(this.departmentService.add(department));
	}

}
