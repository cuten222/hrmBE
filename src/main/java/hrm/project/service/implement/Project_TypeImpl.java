package hrm.project.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrm.project.entity.Project_Type;
import hrm.project.repository.Project_TypeRepository;
import hrm.project.service.Project_TypeService;

@Service
public class Project_TypeImpl implements Project_TypeService{

	private Project_TypeRepository repo;
	
	@Autowired
	public Project_TypeImpl(Project_TypeRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Project_Type> listAllType() {
		List<Project_Type> list = repo.findAll();
		return list;
	}

	@Override
	public Project_Type getType(int id) {
		Optional<Project_Type> type = repo.findById(id);
		return type.get();
	}

}
