package hrm.role.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import hrm.common.entity.AbstractEntity;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity{

	private String roleName;
}
