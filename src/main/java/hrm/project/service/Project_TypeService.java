package hrm.project.service;

import java.util.List;

import hrm.project.entity.Project_Type;

public interface Project_TypeService {
	List<Project_Type> listAllType();
	
	Project_Type getType(int id);
}	
