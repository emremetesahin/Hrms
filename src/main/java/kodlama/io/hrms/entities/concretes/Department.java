package kodlama.io.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="departments")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdversiments"})
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	private int id;
	
	@Column(name="name") 
	@NotBlank
	@NotNull(message = "Boş bırakılamaz")
	private String name;
	
	@Column(name="created_date")
	private LocalDateTime createdDate=LocalDateTime.now();
	
	@Column(name="active")
	private Boolean active=true;
	
	@OneToMany(mappedBy = "department")
	private List<JobAdversiment> jobAdversiments;

}
