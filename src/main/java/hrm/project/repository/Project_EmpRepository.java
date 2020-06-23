package hrm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrm.project.entity.Project_Employee;

public interface Project_EmpRepository extends JpaRepository<Project_Employee, Integer>{
	@Query(value = "Select * from project_emp where del_flag = 0", nativeQuery = true)
	List<Project_Employee> listAll();
}
