package kodlama.io.hrms.core.utilities.helpers.MailHelper;

import kodlama.io.hrms.core.utilities.results.Result;

public interface MailService {
	 Result sendMail(String email,String text);


}
