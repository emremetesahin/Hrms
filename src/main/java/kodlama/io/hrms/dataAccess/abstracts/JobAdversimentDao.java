package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAdversiment;
import kodlama.io.hrms.entities.concretes.dtos.JobAdversimentDetailDto;

public interface JobAdversimentDao extends JpaRepository<JobAdversiment,Integer>{
	@Query("Select new kodlama.io.hrms.entities.concretes.dtos.JobAdversimentDetailDto"
			+ "(j.id,e.companyName,d.name,j.openPosition,j.createdDate,j.applicationDeadline) From JobAdversiment j"
			+ "  Inner Join j.employer e Inner Join j.department d")
	List<JobAdversimentDetailDto> findByActiveAndCanBeAppliedTrue();
	
	@Query("Select new kodlama.io.hrms.entities.concretes.dtos.JobAdversimentDetailDto"
			+ "(j.id,e.companyName,d.name,j.openPosition,j.createdDate,j.applicationDeadline) From JobAdversiment j"
			+ "  Inner Join j.employer e Inner Join j.department d ORDER BY j.applicationDeadline")
	List<JobAdversimentDetailDto> findByActiveAndCanBeAppliedTrueOrderByDate();
	
	@Query("Select new kodlama.io.hrms.entities.concretes.dtos.JobAdversimentDetailDto"
			+ "(j.id,e.companyName,d.name,j.openPosition,j.createdDate,j.applicationDeadline) From JobAdversiment j"
			+ "  Inner Join j.employer e Inner Join j.department d where e.id=:employerId")
	List<JobAdversimentDetailDto> findByActiveTrueAndCanBeAppliedTrueAndEmployerId(int employerId); 
}