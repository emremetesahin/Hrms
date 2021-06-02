package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.MailVeritification;
import kodlama.io.hrms.entities.concretes.User;

public interface MailConfirmService {
	Result ConfirmEmail(MailVeritification veritification);
	Result isConfirmed(String email,int userId);
	Result addCode(User user);
	
}
