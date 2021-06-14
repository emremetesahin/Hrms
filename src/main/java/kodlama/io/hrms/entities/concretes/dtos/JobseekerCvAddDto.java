package kodlama.io.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobseekerCvAddDto {
	private int  jobseekerId;
	private String githubLink;
	private String linkedinLink;
	private String preInformation;
	private String cvTitle;
}
