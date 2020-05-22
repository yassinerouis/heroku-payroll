package customers.project.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customers.project.demo.entities.Activite;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ModeleActivite;
import customers.project.demo.services.ModeleActiviteService;
@RestController
@CrossOrigin
public class ModeleActiviteController {
	@Autowired
	ModeleActiviteService modeleactiviteservice;
	@PostMapping("/saveModeleActivities")
	public void save(@RequestBody List<ModeleActivite> modeleactivites) {
		for(int i=0;i<modeleactivites.size();i++) {
			try {
				modeleactiviteservice.saveModeleActivite(modeleactivites.get(i));
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@GetMapping("/getModeleActivities")
	public List<Activite> getActivities(@RequestBody Modele modele) {
		List<Activite> listActivities=new ArrayList<Activite>();
		for(int i=0;i<modeleactiviteservice.selectModeleActivities(modele).size();i++) {
			listActivities.add(modeleactiviteservice.selectModeleActivities(modele).get(i).getActivite());
		}
		return listActivities;
	}
}
