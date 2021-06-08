package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobseekerAbility;

public interface JobseekerAbilityDao extends JpaRepository<JobseekerAbility,Integer> {

}
