package hrm.user.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hrm.common.entity.AbstractEntity;
import hrm.department.entity.Department;
import hrm.role.entity.Role;

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
}
