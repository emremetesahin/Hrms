package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobseekerCvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobseekerCv;

@RestController
@RequestMapping("/api/jobseekercvs/")
public class JobseekerCvsController {
	private JobseekerCvService JobseekerCvService;

	@Autowired
	public JobseekerCvsController(JobseekerCvService JobseekerCvService) {
		this.JobseekerCvService = JobseekerCvService;
	}

	@PostMapping("add")
	public Result add(@RequestBody JobseekerCv jobseekerCv) {
		return this.JobseekerCvService.add(jobseekerCv);
	}

	@GetMapping("getall")
	public DataResult<List<JobseekerCv>> getAll() {
		return this.JobseekerCvService.getAll();
	}
}
