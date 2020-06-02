package customers.project.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customers.project.demo.entities.Action;
import customers.project.demo.services.ActionService;
@RestController
@CrossOrigin
public class ActionController {
	@Autowired
	ActionService actionservice;
	@PostMapping("/saveaction")
	public Action save(@RequestBody Action action) {
		return actionservice.addAction(action);
	}
	@GetMapping("/getactions")
	public List<Action> getAll() {
		return actionservice.getActions();
	}
	
	@PutMapping("/updateaction")
	public void updateaction(@RequestBody Action action) {
		actionservice.updateAction(action);
	}
	
	@DeleteMapping("/deleteaction/{id}")
	public void delete(@PathVariable("id") long id) {
		actionservice.deleteAction(id);
	}	
	@GetMapping("/selectactions/{activite}")
	public List<Action> selectActions(@PathVariable("activite") long activite) {
		return actionservice.selectActions(activite);
	}	
}