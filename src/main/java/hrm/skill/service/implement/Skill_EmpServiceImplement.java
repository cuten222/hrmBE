package hrm.skill.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import hrm.skill.entity.Skill_Emp;
import hrm.skill.repository.Skill_EmpRepository;
import hrm.skill.service.Skill_EmpService;

public class Skill_EmpServiceImplement implements Skill_EmpService{
	
	private Skill_EmpRepository repo;
	
	@Autowired
	public Skill_EmpServiceImplement(Skill_EmpRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Skill_Emp> listLimitSkill(int start, int pageSize) {
		List<Skill_Emp> list = repo.listLimitSkill(start, pageSize);
		return null;
	}
	
	@Override
	public List<Skill_Emp> listSkill() {
		List<Skill_Emp> list = repo.listAllSkill();
		return list;
	}

	@Override
	public Skill_Emp findSkillByID(int id) {
		Optional<Skill_Emp> skill = repo.findById(id);
		return skill.get();
	}

	@Override
	public Skill_Emp createSkill(Skill_Emp skillEmp) {
		Skill_Emp skill = repo.save(skillEmp);
		return skill;
	}

	@Override
	public Skill_Emp updateSkill(int id, Skill_Emp skillEmpDetail) {
		Skill_Emp skill = findSkillByID(id);
		skill.setSkill(skillEmpDetail.getSkill());
		skill.setLevel(skillEmpDetail.getLevel());
		return repo.save(skill);
	}

	@Override
	public Skill_Emp deleteSkill(int id) {
		Skill_Emp skill = findSkillByID(id);
		skill.setDelFlag(true);
		return repo.save(skill);
	}



}
