package hrm.employee.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrm.employee.entity.Employee;
import hrm.employee.repository.EmployeeRepository;
import hrm.employee.service.EmployeeService;

@Service
public class EmployeeServiceImplement implements EmployeeService{
	public EmployeeRepository empRepo;
	
	@Autowired 
	public EmployeeServiceImplement(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}

	@Override
	public List<Employee> getEmps() {
		List<Employee> empList = empRepo.findAll();
		return empList;
	}

	@Override
	public Employee GetEmpByID(int empID) {
		Optional<Employee> emp = empRepo.findById(empID);
		return emp.get();
	}

	@Override
	public Employee SaveEmp(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public void DelEmp(Employee emp) {
		empRepo.delete(emp);
	}

	@Override
	public List<Employee> getLimitEmps(int start, int limit) {
		List<Employee> listEmpLimit = empRepo.listEmpLimit(start, limit);
		return listEmpLimit;
	}



}
