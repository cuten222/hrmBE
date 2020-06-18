package hrm.department.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import hrm.department.entity.Department;

public interface DeptPaginationService {
	Page<Department> listAllDepts(PageRequest pageRequest);
	
}
