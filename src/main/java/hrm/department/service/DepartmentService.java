package hrm.department.service;

import java.util.List;

import hrm.department.entity.Department;

public interface DepartmentService {
	List<Department> getAllDept();
	
	List<Department> getLimitDept(int start, int pageSize);
	
	Department getDeptByID(int deptID);
	
	Department saveDept(Department dept);
	
	void deleteDept(Department dept);
}
