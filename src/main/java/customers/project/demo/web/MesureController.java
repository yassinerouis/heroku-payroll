package customers.project.demo.web;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import customers.project.demo.entities.Dashboard;
import customers.project.demo.entities.Devise;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.Periode;
import customers.project.demo.services.DeviseService;
import customers.project.demo.services.MesureService;
import customers.project.demo.services.ModeleService;
import customers.project.demo.services.PeriodeService;

@RestController
@CrossOrigin
public class MesureController {
	@Autowired
	ModeleService modeleservice;
	@Autowired
	MesureService mesureservice;
	@Autowired
	DeviseService deviseservice;
	@Autowired
	PeriodeService periodeservice;
	@GetMapping("/filterDashboard/{modele}/{annee}/{mois}/{id_devise}")
	public Dashboard filter(@PathVariable long modele,@PathVariable int annee,@PathVariable int mois,@PathVariable int id_devise) {
		System.out.println("modele"+modele);
		Periode periode=periodeservice.getPeride(annee, mois);
		Devise devise=deviseservice.getDevise(id_devise);		
		return mesureservice.filterDashboard(devise,modeleservice.getModele(modele), periode);
}
	@GetMapping("/getCurrencies")
	public List<Devise> getCurencies() {
			return deviseservice.getAll();
}
	@GetMapping("/Transform/{devise1}/{devise2}")
	public float transform(@PathVariable int devise1,@PathVariable int devise2) {
		return  deviseservice.deviseToDevise(devise1, devise2);
	}
	
}
