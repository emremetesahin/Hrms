package kodlama.io.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobseekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Jobseeker;
 
@RestController
@RequestMapping("/api/jobseekers/")
public class JobseekersController {
	private JobseekerService jobSeekerService;

	@Autowired
	public JobseekersController(JobseekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}

	@GetMapping("getall")
	public DataResult<List<Jobseeker>> getAll() {
		return this.jobSeekerService.getAll();
	}
	@PostMapping("add")
	public ResponseEntity<Result> add(@Valid @RequestBody Jobseeker jobseeker)
	{
		return ResponseEntity.ok(jobSeekerService.add(jobseeker));
	}
	



}
