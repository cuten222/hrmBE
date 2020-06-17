package hrm.skill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrm.skill.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer>{
	@Query(value = "Select * from Skill where del_flag = 0", nativeQuery = true)
	public List<Skill> getAll();
}
