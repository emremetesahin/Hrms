package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobseekerEducationInformationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobseekerEducationInformation;

@RestController
@RequestMapping("/api/jobseekereducationinformations/")
public class JobseekerEducationInformationsController {
	private JobseekerEducationInformationService JobseekerEducationInformationService;

	@Autowired
	public JobseekerEducationInformationsController(JobseekerEducationInformationService JobseekerEducationInformationService) {
		this.JobseekerEducationInformationService = JobseekerEducationInformationService;
	}

	@PostMapping("add")
	public Result add(@RequestBody JobseekerEducationInformation information) {
		return this.JobseekerEducationInformationService.add(information);
	}

	@GetMapping("getall")
	public DataResult<List<JobseekerEducationInformation>> getAll() {
		return this.JobseekerEducationInformationService.getAll();
	}
}
