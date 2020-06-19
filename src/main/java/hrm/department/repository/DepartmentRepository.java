package hrm.department.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrm.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	@Query(value = "Select * from department LIMIT ?, ?", nativeQuery = true)
	List<Department> listDeptLimit(int start, int pageSize);
}
