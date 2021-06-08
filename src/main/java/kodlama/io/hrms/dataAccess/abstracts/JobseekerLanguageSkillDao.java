package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobseekerLanguageSkill;

public interface JobseekerLanguageSkillDao extends JpaRepository<JobseekerLanguageSkill,Integer> {

}
