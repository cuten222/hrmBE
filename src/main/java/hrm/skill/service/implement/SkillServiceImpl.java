package hrm.skill.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrm.skill.entity.Skill;
import hrm.skill.repository.SkillRepository;
import hrm.skill.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService{
	
	public SkillRepository repo;
	
	@Autowired
	public SkillServiceImpl(SkillRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Skill> getAll() {
		List<Skill> skillList = repo.getAll();
		return skillList;
	}

	@Override
	public List<Skill> getLimit(int start, int pageSize) {
		List<Skill> skillList = repo.getLimit(start, pageSize);
		return skillList;
	}

	@Override
	public Skill getByID(int skillID) {
		// TODO Auto-generated method stub
		return repo.findById(skillID).get();
	}

	@Override
	public Skill create(Skill skill) {
		return repo.save(skill);
	}

	@Override
	public Skill update(Skill skillDetail, int id) {
		Skill skill = getByID(id);
		skill.setSkillCode(skillDetail.getSkillCode());
		skill.setDescription(skillDetail.getDescription());
		return repo.save(skill);
	}

	@Override
	public Skill delete(int skillID) {
		Skill skill = getByID(skillID);
		skill.setDelFlag(true);
		return repo.save(skill);
	}


}
