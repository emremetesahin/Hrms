package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobseekerAbilityService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobseekerAbility;

@RestController
@RequestMapping("/api/jobseekerabilities/")
public class JobseekerAbilitiesController {
	private JobseekerAbilityService jobseekerAbilityService;

	@Autowired
	public JobseekerAbilitiesController(JobseekerAbilityService jobseekerAbilityService) {
		this.jobseekerAbilityService = jobseekerAbilityService;
	}

	@PostMapping("add")
	public Result add(@RequestBody JobseekerAbility jobseekerAbility) {
		return this.jobseekerAbilityService.add(jobseekerAbility);
	}

	@GetMapping("getall")
	public DataResult<List<JobseekerAbility>> getAll() {
		return this.jobseekerAbilityService.getAll();
	}
}
