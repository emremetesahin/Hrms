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
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
public class Employer extends User  {

	@NotNull
	@NotBlank
	@Column(name="company_name")
	private String companyName;
	
	@NotNull
	@NotBlank
	@Column(name="phone_number")
	private String phoneNumber;
	
	@NotNull
	@NotBlank
	@Column(name="web_adress")
	private String webAdress;


}
