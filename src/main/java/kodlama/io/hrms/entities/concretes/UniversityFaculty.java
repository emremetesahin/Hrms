package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "university_faculties")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","sections"})
public class UniversityFaculty {
	
	@Id
	@Column(name = "id")
	private int id;
	
//	@Column(name = "university_id")
//	private int universityId;
	
	@NotNull
	@NotEmpty
	@Column(name = "name")
	private String name;

	@Column(name = "active")
	private Boolean active=true;
	
	//Join Columns
	@ManyToOne
	@JoinColumn(name = "university_id")
	private University university;
	
	@OneToMany(mappedBy = "faculty")
	private List<UniversitySection> sections;
	
	}
