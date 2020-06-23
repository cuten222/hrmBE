package hrm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrm.project.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	@Query(value = "select * from project where del_flag = 0", nativeQuery = true)
	List<Project> getAllProject();
	
	@Query(value = "select * from project where del_flag = 0 limit ?,?", nativeQuery = true)
	List<Project> getLimitProject(int start, int pageSize);
}
