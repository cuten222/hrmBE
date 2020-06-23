package hrm.project.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrm.project.entity.Project_Employee;
import hrm.project.service.Project_EmpService;

@CrossOrigin
@RestController
@RequestMapping("/projectEmp")
public class Project_EmpController {
	
	@Autowired
	public Project_EmpService service;
	
	@PostMapping("/create")
	public ResponseEntity<Project_Employee> create(@RequestBody Project_Employee projectEmp){
		try {
			return new ResponseEntity<>(service.create(projectEmp), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/delete/{empID}")
	public ResponseEntity<Project_Employee> delete(@PathVariable("empID") int empID){
		try {
			return new ResponseEntity<>(service.delete(empID), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
