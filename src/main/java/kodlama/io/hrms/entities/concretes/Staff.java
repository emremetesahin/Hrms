package kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="staff")
public class Staff {
	
	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="staff_name")
	private String staffName;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="active")
	private Boolean active;
}
