package kodlama.io.hrms.core.utilities.helpers.MailHelper;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;

public class FakeMailSender implements MailService {
	public Result sendMail(String email,String text)
	{
		return new SuccessResult(email+"Mail Gönderildi");
	}

}
