package hrm.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hrm.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
