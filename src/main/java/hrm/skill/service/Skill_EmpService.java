package hrm.skill.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hrm.skill.entity.Skill_Emp;

@Service
public interface Skill_EmpService {
	
	List<Skill_Emp> findAll();
	
	Skill_Emp findSkillByID(int id);
	
	Skill_Emp createSkill(Skill_Emp skillEmp);
	
	Skill_Emp deleteSkill(int id);
}
