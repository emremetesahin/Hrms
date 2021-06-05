package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.Jobseeker;
import kodlama.io.hrms.entities.concretes.dtos.JobseekerWithVeritificationsDto;

public interface JobseekerDao extends JpaRepository<Jobseeker, Integer> {
	Boolean existsByNationalityId(String nationalityId);

	Jobseeker getByEmailAdress(String email);

	
	//select users.user_id,mail_veritifications.is_confirmed,users.active
	//from users inner join mail_veritifications
	//on users.user_id=mail_veritifications.user_id
}
