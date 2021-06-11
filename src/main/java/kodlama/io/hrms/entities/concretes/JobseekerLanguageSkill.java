package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="jobseeker_language_skills")
public class JobseekerLanguageSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name = "cv_id")
//	private int cvId;
	
//	@Column(name = "language_id")
//	private int languageId;
	
	@Max(value = 5)
	@Column(name = "skill_level")
	private int skillLevel;
	
	//Join Column
	@ManyToOne()
	@JoinColumn(name="language_id")
	private Language language;
	
	@ManyToOne()
	@Getter(value = AccessLevel.PRIVATE)
	@JoinColumn(name="cv_id")
	private JobseekerCv jobseekerCv;
	
}
