package kodlama.io.hrms.entities.concretes.dtos;

import kodlama.io.hrms.entities.concretes.Jobseeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobseekerCvAddDto {
	private Jobseeker jobseeker;
	private String githubLink;
	private String linkedinLink;
	private String preInformation;
	private String cvTitle;
	
}
