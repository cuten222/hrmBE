package hrm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrm.project.entity.Project_Type;
import hrm.project.service.Project_TypeService;

@CrossOrigin
@RestController
@RequestMapping("/projectType")
public class Project_TypeController {
	
	@Autowired
	public Project_TypeService service;
	
	@GetMapping("/list")
	public ResponseEntity<List<Project_Type>> getAllType(){
		try {
			return new ResponseEntity<>(service.listAllType(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get")
	public ResponseEntity<Project_Type> getType(int id){
		try {
			return new ResponseEntity<>(service.getType(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
