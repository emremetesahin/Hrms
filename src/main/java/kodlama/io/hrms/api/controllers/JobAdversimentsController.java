package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlama.io.hrms.business.abstracts.JobAdversimentService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.entities.concretes.JobAdversiment;
import kodlama.io.hrms.entities.concretes.dtos.JobAdversimentGetDto;

@RestController
@RequestMapping("/api/jobadversiments/")
public class JobAdversimentsController {
	private JobAdversimentService jobAdversimentService;

	@Autowired
	public JobAdversimentsController(JobAdversimentService jobAdversimentService) {
		this.jobAdversimentService = jobAdversimentService;
	}
	
	@GetMapping(value = "getactiveandcanbeappliedtrue")
	public DataResult<List<JobAdversimentGetDto>> getActiveAndCanBeAppliedTrue()
	{
		return jobAdversimentService.getActiveAndCanBeAppliedTrue();
	}
	
	@GetMapping(value = "getactiveandcanbeappliedtrueorderbydate")
	public DataResult<List<JobAdversimentGetDto>> getActiveAndCanBeAppliedTrueOrderByDate()
	{
		return jobAdversimentService.getActiveAndCanBeAppliedTrueOrderByDate();
	}

	@PostMapping(value = "add")
	public Result add(@RequestBody JobAdversiment jobAdversiment)
	{
		return this.jobAdversimentService.add(jobAdversiment);
	}
	
	@GetMapping(value="getbyemployerid")
	public DataResult<List<JobAdversimentGetDto>> getByEmployerIdAndActiveAndCanBeAppliedTrue(int employerId)
	{
		return this.jobAdversimentService.getByEmployerIdAndActiveAndCanBeAppliedTrue(employerId);
	}
	
	@GetMapping(value="getall")
	public DataResult<List<JobAdversiment>> getAll() {
		return this.jobAdversimentService.getAll();
	}
	@PostMapping(value = "closetheadd")
	public Result closeTheAd(@RequestParam int adId)
	{
		return this.jobAdversimentService.closeTheAd(adId);
	}
	
	@PostMapping(value = "opentheadd")
	public Result openTheAd(int adId) {
		return this.jobAdversimentService.openTheAd(adId);
	}


}
