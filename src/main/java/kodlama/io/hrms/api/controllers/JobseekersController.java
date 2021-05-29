package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.utilities.DataResult;
import kodlama.io.hrms.core.utilities.Result;
import kodlama.io.hrms.entities.concretes.Jobseeker;
 
@RestController
@RequestMapping("/api/jobseekers/")
public class JobseekersController {
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobseekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}

	@GetMapping("getall")
	public DataResult<List<Jobseeker>> getAll() {
		return this.jobSeekerService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody Jobseeker jobseeker)
	{
		return this.jobSeekerService.add(jobseeker);
	}

}
