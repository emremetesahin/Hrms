package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobseekerCv;
import kodlama.io.hrms.entities.concretes.dtos.JobseekerCvDetailsDto;

public interface JobseekerCvDao extends JpaRepository<JobseekerCv,Integer> {
	
	List<JobseekerCv> getByJobseekerUserId(int jobseekerId);
	JobseekerCv getById(int cvId);

}

