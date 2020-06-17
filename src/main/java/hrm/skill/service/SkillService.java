package hrm.skill.service;

import java.util.List;

import hrm.skill.entity.Skill;

public interface SkillService {
	List<Skill> getAll();
	
	Skill getByID(int skillID);
	
	Skill create(Skill skill);
	
	Skill update(Skill skill, int id);
	
	Skill delete(int skillID);
}
