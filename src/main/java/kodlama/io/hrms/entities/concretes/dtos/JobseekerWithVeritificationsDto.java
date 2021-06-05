package kodlama.io.hrms.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobseekerWithVeritificationsDto {
	private int userId;
	private String email;
//	private Boolean is_confirmed;
//	private Boolean active;
}
