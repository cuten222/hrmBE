package hrm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrm.project.entity.Project_Type;

public interface Project_TypeRepository extends JpaRepository<Project_Type, Integer>{
	@Query(value = "Select * from project_type where del_flag = 0", nativeQuery = true)
	List<Project_Type> listAll();
}
