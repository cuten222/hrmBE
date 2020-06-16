package hrm.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hrm.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
