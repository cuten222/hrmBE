package hrm.employee.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import hrm.common.entity.AbstractEntity;
import hrm.department.entity.Department;
import hrm.skill.entity.Emp_Skill;
import hrm.user.entity.User;

@Entity
@Table(name = "employee")
public class Employee extends AbstractEntity{

	@OneToOne
	@JoinColumn( name = "userID")
	private User user;
	
//	@ManyToOne
//	@JoinColumn(name = "departmentID")
//	private Department dept;
	
	@OneToMany(mappedBy = "emp", cascade = CascadeType.ALL)
	private Collection<Emp_Skill> empSkill;

    @Column(name = "empFirstName")
    private String empFirstName;

    @Column(name = "empLastName")
    private String empLastName;

    @Column(name = "empGender")
    private String empGender;

    @Column(name = "empPhoneNumber")
    private String empPhoneNumber;

    @Column(name = "empAddress")
    private String empAddress;

    @Column(name = "empEmail")
    private String empEmail;

    @Column(name = "empBirthDay")
    private Date empBirthDay;

    @Column(name = "empStartDay")
    private Date empStartDay;

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

	
    
    
}
