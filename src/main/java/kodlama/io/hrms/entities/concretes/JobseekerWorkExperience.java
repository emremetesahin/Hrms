package kodlama.io.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
	private LocalDateTime jobStartDate;
	
	@Column(name = "job_end_date")
	private LocalDateTime JobEndDate;
	
	//Join Columns
	@ManyToOne()
	@Getter(value = AccessLevel.PRIVATE)
	@JoinColumn(name="cv_id")
	private JobseekerCv jobseekerCv;
	
	@ManyToOne()
	@JoinColumn(name="department_id")
	private Department department;	
}
