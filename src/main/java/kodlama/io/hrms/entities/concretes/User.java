package kodlama.io.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","veritifications"})
public  class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@NotBlank
	@NotNull
	@Email(message = "Mail Formatı Hatalı")
	@Column(name = "email_adress")
	private String emailAdress;

	@NotNull
	@NotBlank
	@Column(name = "password")
	private String password;

	@Column(name = "active")
	private Boolean active=false;
	
	@Column(name="created_date")
	private LocalDateTime createdDate=LocalDateTime.now();

}
