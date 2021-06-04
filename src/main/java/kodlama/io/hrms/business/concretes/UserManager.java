package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll(),"Üyeler Listelendi");
	}

	@Override
	public Result add(User user) {
		userDao.save(user);
		return new SuccessResult("Üye eklendi");
		
	}

	@Override
	public Result existsByEmailAdress(User user) {
		Boolean result=userDao.existsByEmailAdress(user.getEmailAdress());
		if(result)
		{
			return new SuccessResult("e posta ile kayıt bulundu");
		}
		else
		{
			return new ErrorResult("E posta kaydı bulunamadı");
		}
	}
	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getByEmailAdress(email));
		
	}

}
