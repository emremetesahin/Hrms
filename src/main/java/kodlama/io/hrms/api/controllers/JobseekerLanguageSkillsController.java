package kodlama.io.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobseekerLanguageSkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobseekerLanguageSkill;

@RestController
@RequestMapping("/api/jobseekerlanguageskills/")
public class JobseekerLanguageSkillsController {
	private JobseekerLanguageSkillService JobseekerLanguageSkillService;

	@Autowired
	public JobseekerLanguageSkillsController(JobseekerLanguageSkillService JobseekerLanguageSkillService) {
		this.JobseekerLanguageSkillService = JobseekerLanguageSkillService;
	}

	@PostMapping("add")
	public Result add(@Valid @RequestBody JobseekerLanguageSkill skill) {
		return this.JobseekerLanguageSkillService.add(skill);
	}

	@GetMapping("getall")
	public DataResult<List<JobseekerLanguageSkill>> getAll() {
		return this.JobseekerLanguageSkillService.getAll();
	}
}
