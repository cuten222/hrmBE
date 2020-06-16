package hrm.department.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import hrm.common.entity.AbstractEntity;

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
