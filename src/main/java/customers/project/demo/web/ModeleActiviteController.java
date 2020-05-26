package customers.project.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customers.project.demo.entities.Activite;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ModeleActivite;
import customers.project.demo.entities.Phase;
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
	@PutMapping("/updateModeleActivities")
	public void update(@RequestBody List<ModeleActivite> modeleactivites) {
		List<ModeleActivite> existModeleActivities=modeleactiviteservice.selectModeleActivities(modeleactivites.get(0).getModele());
		
		for(int i=0;i<modeleactivites.size();i++) {
			for(int j=0;j<existModeleActivities.size();j++) {
				if(existModeleActivities.get(j).getId()!=modeleactivites.get(i).getId()) {
					modeleactiviteservice.saveModeleActivite(modeleactivites.get(i));
			}else {
				modeleactiviteservice.updateModeleActivite(modeleactivites.get(i));
			}
			}
		}
		int inc;
		
		for(int i=0;i<existModeleActivities.size();i++) {
			inc=0;
			for(int j=0;j<modeleactivites.size();j++) {
				if(modeleactivites.get(j).getId()!=existModeleActivities.get(i).getId()) {
					inc++;
			}
				int size=existModeleActivities.size()-1;
				if (inc==size){
					modeleactiviteservice.delete(existModeleActivities.get(i).getId());
				}
			}
		}
	}
	@GetMapping("/getActivitiesPhase/{id_phase}/{id_modele}")
	public List<ModeleActivite> getActivitiesPhase(@PathVariable long id_phase,@PathVariable long id_modele) {
		return modeleactiviteservice.getActivitiesPhases(id_phase,id_modele);
	}
	@GetMapping("/getActivities/{id_modele}")
	public List<Activite> getActivities(@PathVariable long id_modele) {
		Modele modele=modeleactiviteservice.getModele(id_modele);
		List<Activite> listActivities=new ArrayList<Activite>();
		for(int i=0;i<modeleactiviteservice.selectModeleActivities(modele).size();i++) {
			listActivities.add(modeleactiviteservice.selectModeleActivities(modele).get(i).getActivite());
		}
		return listActivities;
	}
	@GetMapping("/getPhases/{id_modele}")
	public List<Long> getPhases(@PathVariable long id_modele) {
		Modele modele=modeleactiviteservice.getModele(id_modele);
		List<Activite> listActivities=this.getActivities(modele.getCode_modele());
		List<Long> listPhases=new ArrayList<Long>();
		for(int i=0;i<listActivities.size();i++) {
			if(listPhases.size()==0) {
				listPhases.add(listActivities.get(i).getPhase().getCode_phase());
			}
			else {
				int non=0;
				for(int j=0;j<listPhases.size();j++) {
					if(listPhases.get(j)!=listActivities.get(i).getPhase().getCode_phase()) {
						non++;
					}
				}
				if(non==listPhases.size()) {
					listPhases.add(listActivities.get(i).getPhase().getCode_phase());
				}
			}		
		}
		return listPhases;
	}
}
