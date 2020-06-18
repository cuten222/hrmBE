package hrm.skill.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import hrm.common.entity.AbstractEntity;
import hrm.employee.entity.Employee;
import hrm.role.entity.Role;
import hrm.user.entity.User;

@Entity
@Table(name= "Skill")
public class Skill extends AbstractEntity{
	@NotNull
	private String skillCode;
	
	@NotNull
	private String description;

	@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
	private Collection<Skill_Emp> skillEmp;
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name = "skill_emp", joinColumns = @JoinColumn(name="skill_id"),inverseJoinColumns = @JoinColumn(name="user_id"))
//	private Collection<Employee> emp;
	
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

//	public Collection<Skill_Emp> getSkillEmp() {
//		return skillEmp;
//	}
//
//	public void setSkillEmp(Collection<Skill_Emp> skillEmp) {
//		this.skillEmp = skillEmp;
//	}
	
	
}
