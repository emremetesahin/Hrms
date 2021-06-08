package kodlama.io.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobseekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Jobseeker;
import kodlama.io.hrms.entities.concretes.dtos.JobseekerWithVeritificationsDto;
 
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
	@GetMapping("getVeritifications")
	public ResponseEntity<DataResult<JobseekerWithVeritificationsDto>>getVeritifications
	(@RequestParam int userId)
	{
		return ResponseEntity.ok(jobSeekerService.getVeritificationValue(userId));
	}
	



}
