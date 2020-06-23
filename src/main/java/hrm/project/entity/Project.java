package hrm.project.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import hrm.common.entity.AbstractEntity;

@Entity
@Table(name="project")
public class Project extends AbstractEntity{
	private String projectName;
	
	private Date dateStart;
	
	private Date estimate;
	
	private Date dateEnd;
	
	private String description;
	
	private int iStatus;
	
	@OneToOne
	@JoinColumn( name = "type_id")
	private Project_Type projectType;
	
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private Collection<Project_Employee> projectEmp;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public int getiStatus() {
		return iStatus;
	}

	public void setiStatus(int iStatus) {
		this.iStatus = iStatus;
	}

	public Date getEstimate() {
		return estimate;
	}

	public void setEstimate(Date estimate) {
		this.estimate = estimate;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project_Type getProjectType() {
		return projectType;
	}

	public void setProjectType(Project_Type projectType) {
		this.projectType = projectType;
	}

	public Collection<Project_Employee> getProjectEmp() {
		return projectEmp;
	}

//	public void setProjectEmp(Collection<Project_Employee> projectEmp) {
//		this.projectEmp = projectEmp;
//	}

	
	
}
