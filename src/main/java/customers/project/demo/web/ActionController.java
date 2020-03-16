package customers.project.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customers.project.demo.entities.Action;
import customers.project.demo.services.ActionService;
@RestController
@CrossOrigin
public class ActionController {
	@Autowired
	ActionService actionservice;
	@PostMapping("/saveaction/{id_status}/{id_activite}/{id_espacetravail}")
	public void save(@RequestBody Action action,@PathVariable int id_status,@PathVariable String id_activite,@PathVariable int id_espacetravail) {
		actionservice.addAction(action, id_status, id_activite, id_espacetravail);
	}
}