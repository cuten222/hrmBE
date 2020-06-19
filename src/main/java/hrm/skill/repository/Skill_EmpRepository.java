package hrm.skill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrm.skill.entity.Skill_Emp;

public interface Skill_EmpRepository extends JpaRepository<Skill_Emp, Integer>{
	@Query(value = "Select * from skill_emp where del_flag = 0", nativeQuery = true)
	List<Skill_Emp> listAllSkill();
	
	@Query(value = "Select * from skill_emp where del_flag = 0 LIMIT ?,?", nativeQuery = true)
	List<Skill_Emp> listLimitSkill(int start, int pageSize);
}
