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
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobseeker_education_informations")
public class JobseekerEducationInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name = "cv_id")
//	private int cvId;
	
//	@Column(name = "section_id")
//	private int sectionId;
	
	
	@Column(name = "school_start_date")
	private LocalDate schoolStartDate;
	
	@Column(name = "school_end_date")
	private LocalDate schoolEndDate;
	
	//Join Columns
	
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private JobseekerCv jobseekerCv;
	
	@ManyToOne()
	@JoinColumn(name = "section_id")
	private UniversitySection section;

}
