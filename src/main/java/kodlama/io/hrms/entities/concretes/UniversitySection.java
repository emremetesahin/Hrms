package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "university_sections")
public class UniversitySection {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name="faculty_id")
	private int faculty_id;
	
	@Column(name = "university_id")
	private int university_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "active")
	private Boolean active=true;
}
