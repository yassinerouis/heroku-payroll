package customers.project.demo.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customers.project.demo.entities.ActiviteSuivi;
import customers.project.demo.entities.InfosActivite;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.PhaseSuivi;
import customers.project.demo.services.ActiviteSuiviService;
import customers.project.demo.services.ModeleSuiviService;
import customers.project.demo.services.PhaseSuiviService;
import customers.project.demo.services.SuiviService;

@RestController
@CrossOrigin
public class ActiviteSuiviController {
	
	@Autowired
	ModeleSuiviService modelesuiviservice;
	@Autowired
	PhaseSuiviService phasesuiviservice;
	@Autowired
	ActiviteSuiviService activitesuiviservice;
	@Autowired
	SuiviService suiviservice;
	@DeleteMapping("/deleteActiviteSuivi/{id}")
	public void delete(@PathVariable("id") int id) {
		activitesuiviservice.delete(id);
	}
	@PostMapping("/sendEmail")
	public void sendMail(@RequestBody InfosActivite activite) {
		activitesuiviservice.sendEmail(activite);
	}
	@PutMapping("/updateStatut/{activite}/{statut}")
	public void updateStatut(@PathVariable long activite,@PathVariable String statut) {
		activitesuiviservice.updateactiviteStatut(activitesuiviservice.getactiviteSuivi(activite),statut);
	}
	@PutMapping("/updateActiviteSuivi/{echeance}")
	public void updateStatut(@RequestBody ActiviteSuivi activitesuivi,@PathVariable int echeance) {
		System.out.println(activitesuivi.getCode_activite());
		activitesuiviservice.updateactiviteSuivi(activitesuivi,echeance);
	}
	@GetMapping("/getModelesUser/{user_id}")
	public List<Modele> getPhases(@PathVariable String user_id){
		List<Modele> modeles=modelesuiviservice.getModeles(activitesuiviservice.selectModeles(user_id));
		for(int i=0;i<modelesuiviservice.findModeles(user_id,modelesuiviservice.getModeles(activitesuiviservice.selectModeles(user_id))).size();i++) {
			modeles.add(modelesuiviservice.findModeles(user_id,modelesuiviservice.getModeles(activitesuiviservice.selectModeles(user_id))).get(i));
		}
		return modeles;
	}
}
