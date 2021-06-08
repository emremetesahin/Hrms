package kodlama.io.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	
	@Column(name = "cv_id")
	private int cvId;
	
	@Column(name = "section_id")
	private int sectionId;
	
	@Column(name = "school_start_date")
	private LocalDateTime schoolStartDate;
	
	@Column(name = "school_end_date")
	private LocalDateTime schoolEndDate;

}