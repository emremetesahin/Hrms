package kodlama.io.hrms.entities.concretes.dtos;


import java.util.List;

import kodlama.io.hrms.entities.concretes.Jobseeker;
import kodlama.io.hrms.entities.concretes.JobseekerAbility;
import kodlama.io.hrms.entities.concretes.JobseekerEducationInformation;
import kodlama.io.hrms.entities.concretes.JobseekerLanguageSkill;
import kodlama.io.hrms.entities.concretes.JobseekerWorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class JobseekerCvDetailsDto {
	private Jobseeker jobseeker;
	private String githubLink;
	private String linkedinLink;
	private String preInformation;
	private Boolean active;
	private String cvTitle;
	 
	private List<JobseekerAbility> abilities;
	private List<JobseekerEducationInformation> educations;
	private List<JobseekerLanguageSkill> languageSkills;
	private List<JobseekerWorkExperience> workExperiences;
}
