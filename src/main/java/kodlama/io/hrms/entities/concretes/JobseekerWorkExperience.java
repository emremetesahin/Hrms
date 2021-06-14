package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobseeker_work_experiences")
public class JobseekerWorkExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name = "cv_id")
//	private int cvId;
	
//	@Column(name = "department_id")
//	private int departmentId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "job_start_date")
	private LocalDate jobStartDate;
	

	@Column(name = "job_end_date")
	private LocalDate jobEndDate;
	
	//Join Columns
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private JobseekerCv jobseekerCv;
	
	@ManyToOne()
	@JoinColumn(name="department_id")
	private Department department;	
}
