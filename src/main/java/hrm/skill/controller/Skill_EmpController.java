package hrm.skill.controller;

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

import hrm.skill.entity.Skill_Emp;
import hrm.skill.service.Skill_EmpService;

@CrossOrigin
@RestController
@RequestMapping("/skill_emp")
public class Skill_EmpController {
	
	@Autowired
	public Skill_EmpService service;
	
	@GetMapping("/list")
	public ResponseEntity<List<Skill_Emp>> getAll(){
		try {
			List<Skill_Emp> list = service.listSkill();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listLimit")
	public ResponseEntity<List<Skill_Emp>> getLimit(@PathParam(value = "start") int start, @PathParam(value = "pageSize") int pageSize){
		try {
			List<Skill_Emp> list = service.listLimitSkill(start, pageSize);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Skill_Emp> findByID(@PathVariable(value = "id") int id){
		try {
			Skill_Emp skill = service.findSkillByID(id);
			return new ResponseEntity<>(skill, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Skill_Emp> create(@RequestBody Skill_Emp skill){
		try {
			return new ResponseEntity<>(service.createSkill(skill), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Skill_Emp> update(@PathVariable(value = "id")int id, @RequestBody Skill_Emp skill){
		try {
			return new ResponseEntity<>(service.updateSkill(id, skill), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<Skill_Emp> delete(@PathVariable(value = "id")int id){
		try {
			return new ResponseEntity<>(service.deleteSkill(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
