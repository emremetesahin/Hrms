package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.MailConfirmService;
import kodlama.io.hrms.core.utilities.results.DataResult;
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

}
