package customers.project.demo.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import customers.project.demo.entities.Activite;
import customers.project.demo.entities.ActiviteSuivi;
import customers.project.demo.entities.InfosActivite;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ModeleActivite;
import customers.project.demo.entities.ModeleSuivi;
import customers.project.demo.entities.Phase;
import customers.project.demo.entities.PhaseSuivi;
import customers.project.demo.entities.Population;
import customers.project.demo.entities.Suivi;
import customers.project.demo.entities.SuiviModele;
import customers.project.demo.services.ActiviteService;
import customers.project.demo.services.ActiviteSuiviService;
import customers.project.demo.services.ModeleActiviteService;
import customers.project.demo.services.ModeleService;
import customers.project.demo.services.ModeleSuiviService;
import customers.project.demo.services.PhaseService;
import customers.project.demo.services.PhaseSuiviService;
import customers.project.demo.services.PopulationService;
import customers.project.demo.services.SuiviService;

@RestController
@CrossOrigin

public class SuiviController {
	@Autowired
	ModeleService modeleservice;
	@Autowired
	SuiviService suiviservice;
	@Autowired
	ModeleSuiviService modelesuiviservice;
	@Autowired
	ModeleActiviteService modeleactiviteservice;
	@Autowired
	PhaseService phaseservice;
	@Autowired
	ActiviteService activiteservice;
	@Autowired
	PhaseSuiviService phasesuiviservice; 
	@Autowired
	ActiviteSuiviService activitesuiviservice; 
	@Autowired
	PopulationService populationservice;
	@GetMapping("/getpopulations/{modele}")
	public Set<Population> getPopulations(@PathVariable long modele) {
		System.out.println(modele);
		 return modeleservice.getPopulations(modele);
	}
	@GetMapping("/getsuivis")
	public void getSuivis() {
		
	}
	@PostMapping("/savesuivi/{id_population}")
	public void save(@RequestBody List<ModeleActivite> activities,@PathVariable int id_population) {
		
		try {
			//le modèle est vide, il y a que l'id je vais remplir les modèles par ses informations
			activities.get(0).setModele(modeleservice.getModele(activities.get(0).getModele().getCode_modele()));
			
			Modele modele=activities.get(0).getModele();
			ModeleSuivi modelesuivi=new ModeleSuivi();
			modelesuivi.setModele_principal(modele.getCode_modele());
			Date date=new Date();
			modelesuivi.setDate_creation(date);
			//creer un modele suivi
			modelesuivi.setModeleSuivi(modele);
			System.out.println("modele");
			System.out.println(modele.getCode_modele());
			List<Phase> phasesModele=modeleactiviteservice.getObjectPhases(modele.getCode_modele());
			modelesuiviservice.addModeleSuivi(modelesuivi);
			Date cible=modelesuivi.getcible();
			//creer les phases suivi
			List<PhaseSuivi> phasesSuivi=new ArrayList<PhaseSuivi>();
			
			for(int i=0;i<phasesModele.size();i++) {
				System.out.println(phasesModele.get(i).getLibelle());
				PhaseSuivi phasesuivi=new PhaseSuivi();
				phasesuivi.setPhaseModele(phasesModele.get(i));
				phasesuivi.setModele(modelesuivi);
				phasesuiviservice.addPhaseSuivi(phasesuivi);
				//System.out.println(phasesuivi.getCode_phase());
				phasesSuivi.add(phasesuivi);
			}
			
			
			for(int i=0;i<phasesModele.size();i++) {
				System.out.println(phasesSuivi.get(i).getCode_phase());
				phasesSuivi.get(i).setPhaseModele(phasesModele.get(i));
				System.out.println("1-"+phasesModele.get(i).getLibelle());
				for(int j=0;j<activities.size();j++) {
					Phase phase=phaseservice.getPhase(activities.get(j).getPhase().getCode_phase());
					if(phase.getLibelle().equals(phasesModele.get(i).getLibelle())) {
						Activite activite=activiteservice.getActivite(activities.get(j).getActivite().getCode_activite());
						activities.get(j).getActivite().setActivite(activite);
						ActiviteSuivi activitesuivi=new ActiviteSuivi();
						activitesuivi.setActivite_principale(activite.getCode_activite());
						Calendar calendar = Calendar.getInstance();
				        calendar.setTime(cible);
				        calendar.add(Calendar.DATE, activities.get(j).getEcheance());
				        activitesuivi.setEcheance(calendar.getTime());
						activitesuivi.setActiviteModele(activities.get(j));
						if(activities.get(j).getActivite().getLibelle()==null) {
							activitesuivi.setActiviteX(activite);
						}
						System.out.println(activitesuivi.getLibelle());
						
						activitesuivi.setEspacetravail(activite.getEspacetravail());
						activitesuivi.setPhasesuivi(phasesSuivi.get(i));
						
						activitesuivi.setStatut("On hold");
						activitesuivi.setResponsable(activities.get(j).getResponsable());
						System.out.println("2-"+activitesuivi.getLibelle());
						activitesuiviservice.addactiviteSuivi(activitesuivi);
					}
				}
			}
			Suivi suivi=new Suivi();
			Calendar calendar=Calendar.getInstance();
			System.out.println(calendar.getTime());
			suivi.setYear(calendar.get(Calendar.YEAR));
			suivi.setMonth(calendar.get(Calendar.MONTH)+1);
			suivi.setModele(modelesuivi);
			suivi.setPopulation(populationservice.getPopulation(id_population));
			suiviservice.savesuivi(suivi);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@GetMapping("get/{id}")
	public ModeleSuivi getid(@PathVariable long id) {
		return modelesuiviservice.getModeleSuivi(id);
	}
	public List<SuiviModele> selectSuivi(ModeleSuivi modelesuivi){
		List<SuiviModele> listActivities=new ArrayList<SuiviModele>();
		List<PhaseSuivi> phases=new ArrayList<PhaseSuivi>();
		List<ActiviteSuivi> activities=new ArrayList<ActiviteSuivi>();
		phases=phasesuiviservice.getPhases(modelesuivi.getCode_modele());
		for(int i=0;i<phases.size();i++) {
			System.out.println(phases.get(i).getCode_phase());
			List<InfosActivite> listinfos=new ArrayList<InfosActivite>();
			activities=activitesuiviservice.getActivities(phases.get(i).getCode_phase());
			SuiviModele suivimodele=new SuiviModele();
			suivimodele.setListphases(phases.get(i));
			for(int j=0;j<activities.size();j++) {
				InfosActivite infos=new InfosActivite();
		        infos.setResponsable(activities.get(j).getResponsable().getNom()+" "+activities.get(j).getResponsable().getPrenom());
		        infos.setImage_responsable((activities.get(j).getResponsable().getNom()+activities.get(j).getResponsable().getPrenom()).replaceAll("\\s", "")+".jpg");
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		        Calendar calendar1 = Calendar.getInstance();
				Date firstDate;
				try {
					firstDate = sdf.parse(sdf.format(calendar1.getTime()));
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(activities.get(j).getEcheance());
					Date secondDate = sdf.parse(sdf.format(calendar.getTime()));
					long diffInMillies =  firstDate.getTime()-secondDate.getTime();
					long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
					Locale loc = new Locale("en", "US");
					DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
					infos.setDate_echeance(dateFormat.format(activities.get(j).getEcheance()));
					infos.setEspacetravail(activities.get(j).getEspacetravail().getLibelle());
					infos.setStatut(diff);
					infos.setId(activities.get(j).getCode_activite());
					infos.setOrdre(activities.get(j).getOrdre_affichage());
					infos.setMatricule(activities.get(j).getResponsable().getMatricule());
					Date cible=activities.get(j).getPhasesuivi().getModele().getcible();
					long diffMillies = activities.get(j).getEcheance().getTime()-cible.getTime();
					long echeance = TimeUnit.DAYS.convert(diffMillies, TimeUnit.MILLISECONDS);
			        infos.setEcheance(echeance);
					infos.setActivite(modelesuiviservice.getActivite(activities.get(j).getActivite_principale()));
					infos.setLibelle_statut(activities.get(j).getStatut());
					String statut=infos.getLibelle_statut();
					if((diff<0) && !(infos.getLibelle_statut().equals("In progress"))&&!(infos.getLibelle_statut().equals("Closed"))) {
						infos.setColor_statut("bg-c-blue");
						System.out.println(statut);
					}
					else if(diff>0) {
						infos.setColor_statut("bg-c-pink");
					}else if(infos.getLibelle_statut().equals("Closed")) {
						infos.setColor_statut("bg-c-green");
					}
					else{
						infos.setColor_statut("bg-c-yellow");
						System.out.println("2");

					}	
					listinfos.add(infos);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			suivimodele.setActivitesuivi(listinfos);
			listActivities.add(suivimodele);
		}
	return listActivities;
	}
	@GetMapping("/getSuivi/{id_modele}")
	public List<SuiviModele> getSuivi(@PathVariable long id_modele) {
		ModeleSuivi modelesuivi=modelesuiviservice.getModeleSuivi(id_modele);
		return this.selectSuivi(modelesuivi);
	}
	@GetMapping("/filterSuivi/{id_modele}/{year}/{month}")
	public List<SuiviModele> filterSuivi(@PathVariable long id_modele,@PathVariable Integer year,@PathVariable Integer month) {
		List<ModeleSuivi> modelessuivi=modelesuiviservice.selectModeleSuivis(id_modele);
		ModeleSuivi modelesuivi=new ModeleSuivi();
		for(int i=0;i<modelessuivi.size();i++) {
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(modelessuivi.get(i).getDate_creation());
			Integer year1=calendar.get(Calendar.YEAR);
			Integer month1=calendar.get(Calendar.MONTH)+1;
			System.out.println(year +""+month);
			System.out.println(year1+""+month1);
			if((year1.equals(year))&&(month1.equals(month))) {
				modelesuivi=modelessuivi.get(i);
			}
		}
		return this.selectSuivi(modelesuivi);
	}
	
}
