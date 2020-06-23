package hrm.project.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import hrm.common.entity.AbstractEntity;

@Entity
@Table(name="project_type")
public class Project_Type extends AbstractEntity{
	private String typeName;
	private String description;
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
