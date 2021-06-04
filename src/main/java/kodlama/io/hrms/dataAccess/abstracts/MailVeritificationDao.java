package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.MailVeritification;

public interface MailVeritificationDao extends JpaRepository<MailVeritification,Integer>{

	MailVeritification getByUserIdAndEmail(int user_id,String email);
	
}
