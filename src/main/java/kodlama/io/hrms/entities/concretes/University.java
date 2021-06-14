package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","faculties"})
@Table(name = "universities")
public class University {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@NotNull
	@NotEmpty
	@Column(name = "name")
	private String name;
	
	@JsonIgnore
	@Column(name = "active")
	private Boolean active=true;
	
	
	//Join Columns
	@OneToMany(mappedBy = "university")
	private List<UniversityFaculty> faculties;
}
