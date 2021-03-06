package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.MailVeritification;
import kodlama.io.hrms.entities.concretes.User;

public interface MailConfirmService {
	Result ConfirmEmail(int user_id,String email,String code);
	DataResult<Boolean> isConfirmed(String email,int userId);
	Result addCode(User user);
	DataResult<List<MailVeritification>> getAll();
}