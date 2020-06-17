package hrm.employee.service;

import java.util.List;

import hrm.employee.entity.Employee;

public interface EmployeeService{
	List<Employee> getEmps();
	
	List<Employee> getLimitEmps(int start, int limit);
	
	Employee GetEmpByID(int empID);
	
	Employee SaveEmp(Employee emp);
	
	void DelEmp(Employee emp);
	
}
