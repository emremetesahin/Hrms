package kodlama.io.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="confirm_user_by_staff")
public class ConfirmUserByStaff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="employer_id")
	private int userId;
	
	@NotNull
	@NotBlank
	@Column(name="staff_id")
	private int staffId;

	@NotNull
	@NotBlank
	@Column(name="is_confirmed")
	private Boolean isConfirmed;
	
	@NotNull
	@NotBlank
	@Column(name="confirm_date")
	private LocalDateTime confirmDate=LocalDateTime.now();

}
