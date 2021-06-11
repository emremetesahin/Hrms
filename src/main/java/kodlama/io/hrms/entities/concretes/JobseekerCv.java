package kodlama.io.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="jobseeker_cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobseeker","abilities","educations","languageSkills","workExperiences"})

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
	
	@Column(name = "active")
	private Boolean active=true;
	
	//JoinColumns
	@ManyToOne()
	@JoinColumn(name = "jobseeker_id")
	private Jobseeker jobseeker;
	
	@OneToMany(mappedBy = "jobseekerCv")
	private List<JobseekerAbility> abilities;
	
	@OneToMany(mappedBy = "jobseekerCv")
	private List<JobseekerEducationInformation> educations; 
	
	@OneToMany(mappedBy = "jobseekerCv")
	private List<JobseekerLanguageSkill> languageSkills;
	
	@OneToMany(mappedBy = "jobseekerCv")
	private List<JobseekerWorkExperience> workExperiences;
	
}
