package kodlama.io.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mail_veritifications")
public class MailVeritification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name = "user_id")
	private int userId;
	
	@NotNull
	@NotBlank
	@Column(name = "email")
	private String email;
	
	@NotNull
	@NotBlank
	@Column(name = "code")
	private String code;
	
	@NotNull
	@NotBlank
	@Column(name = "code_expiration_date")
	private LocalDateTime codeExpirationDate;

	@NotNull
	@NotBlank
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
}
