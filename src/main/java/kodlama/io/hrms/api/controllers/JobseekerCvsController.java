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
import kodlama.io.hrms.entities.concretes.dtos.JobseekerCvAddDto;
import kodlama.io.hrms.entities.concretes.dtos.JobseekerCvDetailsDto;

@RestController
@RequestMapping("/api/jobseekercvs/")
public class JobseekerCvsController {
	private JobseekerCvService JobseekerCvService;

	@Autowired
	public JobseekerCvsController(JobseekerCvService JobseekerCvService) {
		this.JobseekerCvService = JobseekerCvService;
	}

	@PostMapping("add")
	public Result add(@RequestBody JobseekerCvAddDto jobseekerCvAddDto) {
		return this.JobseekerCvService.add(jobseekerCvAddDto);
	}

	@GetMapping("getall")
	public DataResult<List<JobseekerCv>> getAll() {
		return this.JobseekerCvService.getAll();
	}

	@GetMapping("getcvdetails")
	public DataResult<List<JobseekerCvDetailsDto>> getCvDetails() {
		return this.JobseekerCvService.getCvDetails();
	}

	@GetMapping("getcvdetailsbyjobseekerid")
	public DataResult<List<JobseekerCvDetailsDto>> getByJobseekerId(int jobseekerId) {
		return this.JobseekerCvService.getByJobseekerId(jobseekerId);
	}
	@GetMapping("getbyid")
	public DataResult<JobseekerCvDetailsDto> getById(int cvId) {
		return this.JobseekerCvService.getById(cvId);
	}

}