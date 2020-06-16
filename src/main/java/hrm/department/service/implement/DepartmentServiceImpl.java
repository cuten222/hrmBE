package hrm.department.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrm.department.entity.Department;
import hrm.department.repository.DepartmentRepository;
import hrm.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	public DepartmentRepository deptRepo;

	@Autowired
	public DepartmentServiceImpl(DepartmentRepository deptRepo) {
		this.deptRepo = deptRepo;
	}

	@Override
	public List<Department> getAllDept() {
		List<Department> deptList = deptRepo.findAll();
		return deptList;
	}

	@Override
	public Department getDeptByID(int deptID) {
		Optional<Department> dept = deptRepo.findById(deptID);
		return dept.get();
	}

	@Override
	public Department saveDept(Department dept) {
		return deptRepo.save(dept);
	}

	@Override
	public void deleteDept(Department dept) {
		deptRepo.delete(dept);
	}

	
	
	
}
