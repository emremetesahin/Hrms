package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobseekerEducationInformation;

public interface JobseekerEducationInformationDao extends JpaRepository<JobseekerEducationInformation,Integer> {

}
