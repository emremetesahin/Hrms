package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.AbilityService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Ability;

@RestController
@RequestMapping("/api/abilities/")
public class AbilityController {
	private AbilityService abilityService;

	@Autowired
	public AbilityController(AbilityService abilityService) {
		this.abilityService = abilityService;
	}

	@PostMapping("add")
	public Result add(@RequestBody Ability ability) {
		return this.abilityService.add(ability);
	}

	@GetMapping("getall")
	public DataResult<List<Ability>> getAll() {
		return this.abilityService.getAll();
	}
}
