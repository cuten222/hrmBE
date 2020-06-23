package hrm.employee.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import hrm.common.entity.AbstractEntity;
import hrm.department.entity.Department;
import hrm.project.entity.Project_Employee;
import hrm.skill.entity.Skill;
import hrm.skill.entity.Skill_Emp;
import hrm.user.entity.User;

@Entity
@Table(name = "employee")
public class Employee extends AbstractEntity{

	@OneToOne
	@JoinColumn( name = "userID")
	private User user;
	
	@OneToMany(mappedBy = "emp", cascade = CascadeType.ALL)
	private Collection<Skill_Emp> skillEmp;
	
	@OneToMany(mappedBy = "emp", cascade = CascadeType.ALL)
	private Collection<Project_Employee> projectEmp ;

    private String empFirstName;

    private String empLastName;

    private String empGender;

    private String empPhoneNumber;

    private String empAddress;

    private String empEmail;

    private Date empBirthDay;

    private Date empStartDay;
    
//	@ManyToMany(mappedBy = "emp")
//	private Collection<Skill> skill;

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpPhoneNumber() {
		return empPhoneNumber;
	}

	public void setEmpPhoneNumber(String empPhoneNumber) {
		this.empPhoneNumber = empPhoneNumber;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public Date getEmpBirthDay() {
		return empBirthDay;
	}

	public void setEmpBirthDay(Date empBirthDay) {
		this.empBirthDay = empBirthDay;
	}

	public Date getEmpStartDay() {
		return empStartDay;
	}

	public void setEmpStartDay(Date empStartDay) {
		this.empStartDay = empStartDay;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Skill_Emp> getSkillEmp() {
		return skillEmp;
	}

//	public void setSkillEmp(Collection<Skill_Emp> skillEmp) {
//		this.skillEmp = skillEmp;
//	}
//    
}
