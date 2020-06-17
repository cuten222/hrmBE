package hrm.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrm.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query(value = "SELECT * FROM Employee LIMIT ?, ?", nativeQuery = true)
	List<Employee> listEmpLimit(int start, int limit);
	
}
