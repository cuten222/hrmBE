package hrm.department.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class DeptResponse implements Serializable{
	private int id;
	private String deptName;

	private String deptCode;

	private boolean delFlag = false;

	private Date createdAt;

	private Date updatedAt;

	private int createdBy;

	private int updatedBy;

	public DeptResponse(Department dept) {
		super();
		this.id = dept.getId();
		this.deptName = dept.getDeptName();
		this.deptCode = dept.getDeptCode();
		this.delFlag = dept.isDelFlag();
		this.createdAt = dept.getCreatedAt();
		this.updatedAt = dept.getUpdatedAt();
		this.createdBy = dept.getCreatedBy();
		this.updatedBy = dept.getUpdatedBy();
	}

}
