package hrm.skill.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import hrm.common.entity.AbstractEntity;
import hrm.employee.entity.Employee;
import hrm.role.entity.Role;

@Entity
@Table(name= "Skill")
public class Skill extends AbstractEntity{
	@NotNull
	private String skillCode;
	
	@NotNull
	private String description;
	
	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
	private Collection<Emp_Skill> empSkill;


	public String getSkillCode() {
		return skillCode;
	}

	public void setSkillCode(String skillCode) {
		this.skillCode = skillCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
