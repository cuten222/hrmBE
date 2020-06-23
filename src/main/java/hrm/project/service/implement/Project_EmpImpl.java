package hrm.project.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrm.project.entity.Project_Employee;
import hrm.project.repository.Project_EmpRepository;
import hrm.project.service.Project_EmpService;

@Service
public class Project_EmpImpl implements Project_EmpService{
		
	private Project_EmpRepository repo;

	@Autowired
	public Project_EmpImpl(Project_EmpRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Project_Employee create(Project_Employee projectEmp) {
		return repo.save(projectEmp);
	}

	@Override
	public Project_Employee findByID(int empID) {
		return repo.findById(empID).get();
	}
	
	@Override
	public Project_Employee delete(int empID) {
		Project_Employee projectEmployee = findByID(empID);
		projectEmployee.setDelFlag(true);		
		return repo.save(projectEmployee);
	}

}
