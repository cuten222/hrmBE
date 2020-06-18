package hrm.department.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrm.department.entity.Department;
import hrm.department.repository.DeptPaginationRepository;
import hrm.department.service.DeptPaginationService;

@Service
public class DeptPaginationServiceImpl implements DeptPaginationService{
	private DeptPaginationRepository deptPaginationRepo;

	@Autowired
	public DeptPaginationServiceImpl(DeptPaginationRepository deptPaginationRepo) {
		this.deptPaginationRepo = deptPaginationRepo;
	}

	@Override
	public Page<Department> listAllDepts(PageRequest pageRequest) {
		Page<Department> pageResult = deptPaginationRepo.findAll(pageRequest);
		return pageResult;
	}
	
}
