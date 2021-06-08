package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobseekerWorkExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobseekerWorkExperience;

@RestController
@RequestMapping("/api/jobseekerworkexperiences/")
public class JobseekerWorkExperiencesController {
	private JobseekerWorkExperienceService jobseekerWorkExperienceService;

	@Autowired
	public JobseekerWorkExperiencesController(JobseekerWorkExperienceService JobseekerWorkExperienceService) {
		this.jobseekerWorkExperienceService = JobseekerWorkExperienceService;
	}

	@PostMapping("add")
	public Result add(@RequestBody JobseekerWorkExperience jobseekerWorkExperience) {
		return this.jobseekerWorkExperienceService.add(jobseekerWorkExperience);
	}

	@GetMapping("getall")
	public DataResult<List<JobseekerWorkExperience>> getAll() {
		return this.jobseekerWorkExperienceService.getAll();
	}
}
