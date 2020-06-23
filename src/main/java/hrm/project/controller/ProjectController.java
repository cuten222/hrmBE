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

import hrm.project.entity.Project;
import hrm.project.entity.ReqProject;
import hrm.project.service.ProjectService;

@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	public ProjectService service;
	
	@GetMapping("/list")
	public ResponseEntity<List<Project>> listProject(){
		try {
			List<Project> list = service.listAll();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/listLimit")
	public ResponseEntity<List<Project>> listLimitProject(@PathParam(value = "start") int start, @PathParam(value = "pageSize")int pageSize){
		try {
			return new ResponseEntity<>(service.listLimit(start, pageSize), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Project> getProjectByID(@PathVariable(value = "id") int id) {
		try {
			Project project = service.findByID(id);
			return new ResponseEntity<>(project, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/create")
	public ResponseEntity<Project> createProject(@RequestBody ReqProject request){
		try {
			return new ResponseEntity<>(service.create(request), HttpStatus.OK);
		} catch (Exception e) {	
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable(value = "id") int id, @RequestBody ReqProject request){
		try {
			return new ResponseEntity<>(service.update(request, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/delete/{id}")
	public ResponseEntity<Project> deleteProject(@PathVariable(value = "id") int id){
		try {
			return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
