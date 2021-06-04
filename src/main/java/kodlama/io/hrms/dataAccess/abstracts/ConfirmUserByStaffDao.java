package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.ConfirmUserByStaff;

public interface ConfirmUserByStaffDao  extends JpaRepository<ConfirmUserByStaff,Integer>{

}
