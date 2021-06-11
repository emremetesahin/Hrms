package kodlama.io.hrms.entities.concretes.dtos;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdversimentDetailDto {
	private int AdversimentId;
	private String companyName;
	private String departmentName;
	private int openPosition;
	private LocalDateTime createdDate;
	private LocalDateTime applicationDeadline;
}
