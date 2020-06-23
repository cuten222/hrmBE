package hrm.skill.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import hrm.employee.entity.Employee;

@Entity
@Table(name="skill_emp")
public class Skill_Emp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int level;
	
	private boolean delFlag = false;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name= "skill_id")
	private Skill skill;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name ="emp_id")
	private Employee emp;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

//	public Employee getEmp() {
//		return emp;
//	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	
}
