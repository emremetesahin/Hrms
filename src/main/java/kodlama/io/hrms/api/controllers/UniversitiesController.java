package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.UniversityService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.University;

@RestController
@RequestMapping("/api/universities/")
public class UniversitiesController {
	private UniversityService universityService;

	@Autowired
	public UniversitiesController(UniversityService universityService) {
		this.universityService = universityService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody University university)
	{
		return this.universityService.add(university);
	}
	
	@GetMapping("getall")
	public DataResult<List<University>>getAll()
	{
		return this.universityService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<University> getById(int id)
	{
		return this.universityService.getById(id);
	}

}
