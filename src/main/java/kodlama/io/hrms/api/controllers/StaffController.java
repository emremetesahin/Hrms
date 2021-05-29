package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.StaffService;
import kodlama.io.hrms.core.utilities.DataResult;
import kodlama.io.hrms.core.utilities.Result;
import kodlama.io.hrms.entities.concretes.Staff;
 
@RestController
@RequestMapping("/api/staff/")
public class StaffController {
	private StaffService staffService;

	@Autowired
	public StaffController(StaffService staffService) {
		this.staffService = staffService;
	}

	@GetMapping("getall")
	public DataResult<List<Staff>> getAll() {
		return this.staffService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody Staff jobseeker)
	{
		return this.staffService.add(jobseeker);
	}

}
