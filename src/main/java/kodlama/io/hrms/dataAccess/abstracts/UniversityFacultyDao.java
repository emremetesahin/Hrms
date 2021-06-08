package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.UniversityFaculty;

public interface UniversityFacultyDao extends JpaRepository<UniversityFaculty,Integer> {

}
