package hrm.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import hrm.employee.entity.Employee;
import hrm.employee.service.EmployeeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<Employee>> getEmp(){
		try {
			List<Employee> empList = empService.getEmps();
			return new ResponseEntity<>(empList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/get/{empID}")
	public ResponseEntity<Employee> searchEmpByID(@PathVariable("empID") int empID){
		try {
			Employee emp = empService.GetEmpByID(empID);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		try {
			return new ResponseEntity<>(empService.SaveEmp(emp), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int empID, @RequestBody Employee empDetail){
		try {
			Employee emp = empService.GetEmpByID(empID);
			
			emp.setEmpFirstName(empDetail.getEmpFirstName());
			emp.setEmpLastName(empDetail.getEmpLastName());
			emp.setEmpGender(empDetail.getEmpGender());
			emp.setEmpAddress(empDetail.getEmpAddress());
			emp.setEmpPhoneNumber(empDetail.getEmpPhoneNumber());
			emp.setEmpEmail(empDetail.getEmpEmail());
			emp.setEmpBirthDay(empDetail.getEmpBirthDay());
			emp.setEmpStartDay(empDetail.getEmpStartDay());
			
			final Employee updatedEmp = empService.SaveEmp(empDetail);
			return ResponseEntity.ok(updatedEmp);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int empID){
		try {
			Employee emp = empService.GetEmpByID(empID);
			empService.DelEmp(emp);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
