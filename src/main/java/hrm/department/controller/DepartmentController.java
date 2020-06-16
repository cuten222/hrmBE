package hrm.department.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrm.department.entity.Department;
import hrm.department.entity.DeptResponse;
import hrm.department.service.DepartmentService;
import hrm.department.service.DeptPaginationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;

	@Autowired
	private DeptPaginationService deptPaginationService;

	@GetMapping(value = "/list")
	public Page<DeptResponse> listDept(@RequestParam(name = "page", defaultValue = "0") int page,
									@RequestParam(name = "size", defaultValue = "5") int size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Department> pageResult = deptPaginationService.listAllDepts(pageRequest);
		List<DeptResponse> deptList = pageResult.stream().map(DeptResponse::new).collect(Collectors.toList());
		
		return new PageImpl<>(deptList, pageRequest, pageResult.getTotalElements());
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Department> searchDeptByID(@PathVariable("id") int deptID) {
		try {
			return new ResponseEntity<>(deptService.getDeptByID(deptID), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Department> createDept(@RequestBody Department dept) {
		try {
			return new ResponseEntity<>(deptService.saveDept(dept), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Department> updateDept(@PathVariable("id") int deptID, @RequestBody Department deptDetail) {
		try {
			Department dept = deptService.getDeptByID(deptID);

			dept.setDeptCode(deptDetail.getDeptCode());
			dept.setDeptName(deptDetail.getDeptName());
			return ResponseEntity.ok(deptService.saveDept(dept));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Department> deleteDept(@PathVariable("id") int deptID) {
		try {
			Department dept = deptService.getDeptByID(deptID);
			deptService.deleteDept(dept);
			return new ResponseEntity<>(dept, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
