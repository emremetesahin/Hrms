package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.MailConfirmService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.MailVeritification;

@RestController
@RequestMapping("/api/mailconfirms/")
public class MailConfirmsController {
	private MailConfirmService mailConfirmService;

	@Autowired
	public MailConfirmsController(MailConfirmService mailConfirmService) {
		this.mailConfirmService = mailConfirmService;
	}
	
	@GetMapping("getall")
	public DataResult<List<MailVeritification>>getAll()
	{
		return this.mailConfirmService.getAll();
	}
	@PostMapping("confirmEmail")
	public Result confirmEmail(int userId, String email, String code)
	{
		return this.mailConfirmService.ConfirmEmail(userId,email,code);
	}
	@GetMapping("isConfirmed")
	public DataResult<Boolean>isConfirmed(@RequestParam int userId,@RequestParam String email)
	{
		return this.mailConfirmService.isConfirmed(email, userId);
	}

}
