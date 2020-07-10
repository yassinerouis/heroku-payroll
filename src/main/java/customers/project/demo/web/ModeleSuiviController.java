package customers.project.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import customers.project.demo.services.ModeleSuiviService;

@RestController
@CrossOrigin
public class ModeleSuiviController {
	@Autowired
	ModeleSuiviService modelesuiviservice;
	/*@GetMapping("/getModeles/{user_id}")
	public List<Modele> getAll(@PathVariable String user_id) {
		
	}*/
}
