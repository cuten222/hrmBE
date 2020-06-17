package hrm.skill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrm.skill.entity.Emp_Skill;

public interface Emp_SkillRepository extends JpaRepository<Emp_Skill, Integer>{
	@Query(value = "Select skillid as skillCode, level from emp_skill join employee on employee.id = emp_skill.empid \r\n" + 
					"join skill on skill.id = emp_skill.skillid \r\n" + 
					"where emp_skill.del_flag = 0;", nativeQuery = true)
	List<Emp_Skill> getSkillList();
}
