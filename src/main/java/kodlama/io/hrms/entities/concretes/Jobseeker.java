package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="jobseekers")
@AllArgsConstructor
@NoArgsConstructor
public class Jobseeker extends User {

	@NotNull
	@NotBlank
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@NotBlank
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@NotBlank
	@Column(name="nationality_id")
	private String nationalityId;
	
	
	
	@Column(name="year_of_birth")
	private int yearOfBirth;

}
