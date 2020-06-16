package hrm.department.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import hrm.department.entity.Department;

public interface DeptPaginationRepository extends PagingAndSortingRepository<Department, Integer>{

}
