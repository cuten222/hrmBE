package hrm.department.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import hrm.common.entity.AbstractEntity;
import hrm.employee.entity.Employee;

@Entity
@Table(name = "department")
public class Department extends AbstractEntity {
	private String deptName;
	
	private String deptCode;
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

}
