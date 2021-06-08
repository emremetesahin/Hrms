package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Ability;
import kodlama.io.hrms.entities.concretes.JobseekerPicture;

public interface JobseekerPictureDao extends JpaRepository<JobseekerPicture,Integer> {

}
