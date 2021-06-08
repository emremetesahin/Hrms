package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobseekerPictureService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobseekerPicture;

@RestController
@RequestMapping("/api/jobseekerpictures/")
public class JobseekerPicturesController {
	private JobseekerPictureService JobseekerPictureService;

	@Autowired
	public JobseekerPicturesController(JobseekerPictureService JobseekerPictureService) {
		this.JobseekerPictureService = JobseekerPictureService;
	}

	@PostMapping("add")
	public Result add(@RequestBody JobseekerPicture picture) {
		return this.JobseekerPictureService.add(picture);
	}

	@GetMapping("getall")
	public DataResult<List<JobseekerPicture>> getAll() {
		return this.JobseekerPictureService.getAll();
	}
}
