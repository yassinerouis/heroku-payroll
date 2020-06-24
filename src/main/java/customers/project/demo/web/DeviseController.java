package customers.project.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import customers.project.demo.entities.Devise;
import customers.project.demo.services.DeviseService;
@RestController
@CrossOrigin
public class DeviseController {
	@Autowired
	DeviseService deviseservice;

	@GetMapping("/getDevise/{id_pays}")
	public Devise getdevise(@PathVariable int id_pays) {
		System.out.println(id_pays+"-"+deviseservice.getDevise(id_pays).getSymbol());
		
		return deviseservice.getDevisePays(id_pays);
	}
	
	
}