package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobseekerWorkExperience;

public interface JobseekerWorkExperienceDao extends JpaRepository<JobseekerWorkExperience,Integer> {

}
