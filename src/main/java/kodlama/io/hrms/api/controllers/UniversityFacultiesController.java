package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.UniversityFacultyService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.UniversityFaculty;

@RestController
@RequestMapping("/api/universityfaculties/")
public class UniversityFacultiesController {
	private UniversityFacultyService universityService;

	@Autowired
	public UniversityFacultiesController(UniversityFacultyService universityService) {
		this.universityService = universityService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody UniversityFaculty UniversityFaculty)
	{
		return this.universityService.add(UniversityFaculty);
	}
	@GetMapping("getall")
	public DataResult<List<UniversityFaculty>>getAll()
	{
		return this.universityService.getAll();
	}
}
