package hrm.skill.controller;

import java.util.List;

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

import hrm.skill.entity.Skill;
import hrm.skill.service.SkillService;

@CrossOrigin
@RestController
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	private SkillService service;
	
	@GetMapping("/list")
	public ResponseEntity<List<Skill>> skillGets(){
		try {
			List<Skill> skillList = service.getAll();
			return new ResponseEntity<>(skillList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Skill> skillGet(@PathVariable(value = "id") int id){
		try {
			return new ResponseEntity<>(service.getByID(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/create")
	public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
		try {
			return new ResponseEntity<>(service.create(skill), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Skill> updateSkill(@PathVariable(value = "id") int id, @RequestBody Skill skill){
		try {
			return new ResponseEntity<>(service.update(skill, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<Skill> deleteSkill(@PathVariable(value = "id") int id){
		try {
			return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
