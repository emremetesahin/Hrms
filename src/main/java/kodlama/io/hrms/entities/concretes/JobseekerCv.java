package kodlama.io.hrms.entities.concretes;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

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
@Table(name ="jobseeker_cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","abilities","educations","languageSkills","workExperiences"})

public class JobseekerCv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name = "jobseeker_id")
//	private int jobseekerId;
	
	@NotNull
	@NotEmpty
	@Column(name="cv_title")
	private String cvTitle;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	@Column(name = "pre_information")
	private String preInformation;
	
	@JsonIgnore
	@Column(name = "active")
	private Boolean active=true;
	
	@JsonIgnore
	@CreatedDate
	@Column(name="created_date")
	private LocalDateTime createdDate=LocalDateTime.now();
	
	//JoinColumns//
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "jobseeker_id")
	private Jobseeker jobseeker;	
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseekerCv")
	private List<JobseekerAbility> abilities;
	
	@JsonIgnore
	@OrderBy("schoolEndDate DESC")
	@OneToMany(mappedBy = "jobseekerCv")
	private List<JobseekerEducationInformation> educations; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobseekerCv")
	private List<JobseekerLanguageSkill> languageSkills;

	@OrderBy("jobEndDate DESC")
	@OneToMany(mappedBy = "jobseekerCv")
	private List<JobseekerWorkExperience> workExperiences;
	
}
