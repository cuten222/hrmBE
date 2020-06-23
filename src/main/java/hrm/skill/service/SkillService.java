package hrm.skill.service;

import java.util.List;

import hrm.skill.entity.Skill;

public interface SkillService {
	List<Skill> getAll();
	
	List<Skill> getLimit(int start, int pageSize);
	
	Skill getByID(int skillID);
	
	Skill create(Skill skill);
	
	Skill update(Skill skill, int id);
	
	Skill delete(int skillID);
}
