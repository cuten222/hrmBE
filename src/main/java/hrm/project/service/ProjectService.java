package hrm.project.service;

import java.util.List;

import hrm.project.entity.Project;
import hrm.project.entity.ReqProject;

public interface ProjectService {
	List<Project> listAll();
	
	List<Project> listLimit(int start, int pageSize);
	
	Project findByID(int id);
	
	Project create(ReqProject request);
	
	Project update(ReqProject request, int id);
	
	Project delete(int id);
}
