package hrm.skill.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrm.skill.entity.Emp_Skill;
import hrm.skill.repository.Emp_SkillRepository;
import hrm.skill.service.Emp_SkillService;

@Service
public class Emp_SkillServiceImpl implements Emp_SkillService{
	
	public Emp_SkillRepository repo;

	@Autowired
	public Emp_SkillServiceImpl(Emp_SkillRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Emp_Skill> listSkill() {
		List<Emp_Skill> listSkill = repo.getSkillList();
		return listSkill;
	}
	
	

}
