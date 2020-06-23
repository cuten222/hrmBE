package hrm.project.service;

import java.util.List;

import hrm.project.entity.Project_Employee;

public interface Project_EmpService {
	Project_Employee create(Project_Employee projectEmp);
	
	Project_Employee findByID(int empID);
	
	Project_Employee delete(int empID);
}
