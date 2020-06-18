package hrm.user.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hrm.common.entity.AbstractEntity;
import hrm.department.entity.Department;
import hrm.role.entity.Role;
import hrm.skill.entity.Skill;

@Entity
@Table(name = "user")
public class User extends AbstractEntity{

	private String userName;
	
	private String password;
	
	@ManyToOne
	@JoinColumn(name= "roleID")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name ="deptID")
	private Department dept;
	
//	@ManyToMany(mappedBy = "user")
//	private Collection<Skill> skill;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	
}
