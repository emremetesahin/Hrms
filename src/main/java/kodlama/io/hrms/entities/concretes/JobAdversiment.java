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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_adversiments")

public class JobAdversiment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name ="employer_id" )
//	private int employerId;
	
//	@Column(name ="department_id" )
//	private int departmentId;
	
//	@Column(name="city_id")
//	private int cityId;

	@Column(name = "description")
	private String description;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name ="open_position" )
	private int openPosition;
	
	@Column(name ="application_deadline" )
	private LocalDateTime applicationDeadline=
	LocalDateTime.now().plusHours(minSalary); //Farklı tarih oluşturması için
	
	@Column(name="created_date")
	private LocalDateTime createdDate=LocalDateTime.now();
	
	@Column(name ="can_be_applied")
	private Boolean canBeApplied;
	
	@Column(name="active")
	private Boolean active=true;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name="department_id")
	private Department department;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
}
