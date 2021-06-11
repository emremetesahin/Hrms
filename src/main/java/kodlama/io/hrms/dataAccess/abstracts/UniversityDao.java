package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.University;

public interface UniversityDao extends JpaRepository<University,Integer> {
	University findById(int id);

}
