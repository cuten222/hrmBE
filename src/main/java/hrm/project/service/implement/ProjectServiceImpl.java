package hrm.project.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import hrm.project.entity.Project;
import hrm.project.entity.Project_Type;
import hrm.project.entity.ReqProject;
import hrm.project.repository.ProjectRepository;
import hrm.project.repository.Project_TypeRepository;
import hrm.project.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	private ProjectRepository repo;
	private Project_TypeRepository typeRepo;
	
	@Autowired
	public ProjectServiceImpl(ProjectRepository repo, Project_TypeRepository typeRepo) {
		super();
		this.repo = repo;
		this.typeRepo = typeRepo;
	}

	@Override
	public List<Project> listAll() {
		List<Project> list = repo.getAllProject();
		return list;
	}

	@Override
	public List<Project> listLimit(int start, int pageSize) {
		List<Project> list = repo.getLimitProject(start, pageSize);
		return list;
	}

	@Override
	public Project findByID(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Project create(ReqProject request) {
		
		Optional<Project_Type> pt = typeRepo.findById(request.getType_id());
		System.out.println(request.getType_id());
		if(pt.isPresent()) {
			Project project = new Project();
			project.setProjectName(request.getProjectName());
			project.setDateStart(request.getDateStart());
			project.setEstimate(request.getEstimate());
			project.setDateEnd(request.getDateEnd());
			project.setDescription(request.getDescription());
			project.setiStatus(request.getiStatus());
			project.setProjectType(pt.get());
			return repo.save(project);
		}else {
			System.out.println("project Create: " + HttpStatus.BAD_REQUEST);
			return null;
		}
		
	}

	@Override
	public Project update(ReqProject request, int id) {
		Optional<Project_Type> pt = typeRepo.findById(request.getType_id());
		Project project = findByID(id);
		project.setProjectName(request.getProjectName());
		project.setDateStart(request.getDateStart());
		project.setEstimate(request.getEstimate());
		project.setDateEnd(request.getDateEnd());
		project.setDescription(request.getDescription());
		project.setiStatus(request.getiStatus());
		project.setProjectType(pt.get());
		return repo.save(project);
	}

	@Override
	public Project delete(int id) {
		Project project = findByID(id);
		project.setDelFlag(false);
		return repo.save(project);
	}

}
