package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobseeker_abilities")
public class JobseekerAbility {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

//	@Column(name = "cv_id")
//	private int cvId;
	
//	@Column(name = "ability_id")
//	private int abilityId;
//	
	//join columns
	@ManyToOne
	@JoinColumn(name = "cv_id")
	@Getter(value = AccessLevel.PRIVATE)
	JobseekerCv jobseekerCv;
	
	@ManyToOne
	@JoinColumn(name="ability_id")
	Ability ability;
	
	
}
