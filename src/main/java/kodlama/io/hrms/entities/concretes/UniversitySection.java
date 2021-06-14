package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "university_sections")
public class UniversitySection {
	
	@Id
	@Column(name = "id")
	private int id;
	
//	@Column(name="faculty_id")
//	private int faculty_id;
//	
//	@Column(name = "university_id")
//	private int university_id;
	
	@NotNull
	@NotEmpty
	@Column(name = "name")
	private String name;
	
	@JsonIgnore
	@Column(name = "active")
	private Boolean active=true;

	
	//Join Columns
	@ManyToOne
	@JoinColumn(name="faculty_id")
	private UniversityFaculty faculty;
}
