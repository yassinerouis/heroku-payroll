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
import org.springframework.web.bind.annotation.PutMapping;
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
		 return modeleservice.getPopulations(modeleservice.getTypePopulation(modele));
	}
	@GetMapping("/getPopulations/{type_population}")
	public Set<Population> getpopulations(@PathVariable int type_population) {
		 return modeleservice.getPopulations(type_population);
	}
	@GetMapping("/selectSuivi/{modele}")
	public Suivi getSuivis(@PathVariable long modele) {
		System.out.println("modele"+modele);
		return suiviservice.selectSuivi(modele);
	}
	@PutMapping("/updateSuivi")
	public void updateSuivi(@RequestBody Suivi suivi) {
		 suiviservice.updatesuivi(suivi);
	}
	@PostMapping("/savesuivi/{id_population}")
	public void save(@RequestBody List<ModeleActivite> activities,@PathVariable int id_population) {
		try {
			//je récupère le modèle des activités du suivi à créer qui sont envoyées par le front-end
			activities.get(0).setModele(modeleservice.getModele(activities.get(0).getModele().getCode_modele()));
			Modele modele=activities.get(0).getModele();
			ModeleSuivi modelesuivi=new ModeleSuivi();
			modelesuivi.setModele_principal(modele.getCode_modele());
			//je crée un modèle suivi (c'est à dire l'image du modèle de ce suivi)
			Date date=new Date();
			modelesuivi.setDate_creation(date);
			modelesuivi.setModeleSuivi(modele);
			//Enregistrer une image des phases de ses activités, pour ce modèle suivi enregistré
			List<Phase> phasesModele=modeleactiviteservice.getObjectPhases(modele.getCode_modele());
			modelesuiviservice.addModeleSuivi(modelesuivi);
			List<PhaseSuivi> phasesSuivi=new ArrayList<PhaseSuivi>();
			for(int i=0;i<phasesModele.size();i++) {
				PhaseSuivi phasesuivi=new PhaseSuivi();
				phasesuivi.setPhaseModele(phasesModele.get(i));
				phasesuivi.setModele(modelesuivi);
				phasesuiviservice.addPhaseSuivi(phasesuivi);
				phasesSuivi.add(phasesuivi);
			}
			//Enregistrer une image des activités choisit pour chaque phase du modèle en suivi
			Date cible=modelesuivi.getcible();
			for(int i=0;i<phasesModele.size();i++) {
				phasesSuivi.get(i).setPhaseModele(phasesModele.get(i));
				for(int j=0;j<activities.size();j++) {
					Phase phase=phaseservice.getPhase(activities.get(j).getPhase().getCode_phase());
					if(phase.getLibelle().equals(phasesModele.get(i).getLibelle())) {
						//REMPLIR LES CHAMPS DE L'ACTIVITE EN SUIVI
						Activite activite=activiteservice.getActivite(activities.get(j).getActivite().getCode_activite());
						activities.get(j).getActivite().setActivite(activite);
						ActiviteSuivi activitesuivi=new ActiviteSuivi();
						activitesuivi.setActivite_principale(activite.getCode_activite());
						//CALCULER LA DATE D'ECHEANCE
						Calendar calendar = Calendar.getInstance();
				        calendar.setTime(cible);
				        calendar.add(Calendar.DATE, activities.get(j).getEcheance());
				        activitesuivi.setEcheance(calendar.getTime());
						activitesuivi.setActiviteModele(activities.get(j));		
						activitesuivi.setEspacetravail(activite.getEspacetravail());
						activitesuivi.setPhasesuivi(phasesSuivi.get(i));
						activitesuivi.setStatut("En attente");
						activitesuivi.setResponsable(activities.get(j).getResponsable());
						//SI L'ACTIVITE N'EXISTE PAS DANS LE MODELE (MAIS IL EXISTE DANS LA PHASE)
						if(activities.get(j).getActivite().getLibelle()==null) {
							activitesuivi.setActiviteX(activite);
						}
						activitesuiviservice.addactiviteSuivi(activitesuivi);
					}
				}
			}
			//Créer le suivi
			Suivi suivi=new Suivi();
			Calendar calendar=Calendar.getInstance();
			
			suivi.setYear(calendar.get(Calendar.YEAR));
			suivi.setMonth(calendar.get(Calendar.MONTH)+1);
			suivi.setModele(modelesuivi);
			suivi.setPopulation(populationservice.getPopulation(id_population));
			suivi.setClotured(false);
			suiviservice.savesuivi(suivi);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<SuiviModele> selectSuivi(ModeleSuivi modelesuivi){
		List<SuiviModele> listActivities=new ArrayList<SuiviModele>();
		List<PhaseSuivi> phases=new ArrayList<PhaseSuivi>();
		List<ActiviteSuivi> activities=new ArrayList<ActiviteSuivi>();
		phases=phasesuiviservice.getPhases(modelesuivi.getCode_modele());
		int k1=0;
		int k2=0;
		SimpleDateFormat formater = null;
		Date cible=null;
		for(int i=0;i<phases.size();i++) {
			List<InfosActivite> listinfos=new ArrayList<InfosActivite>();
			activities=activitesuiviservice.getActivities(phases.get(i).getCode_phase());
			SuiviModele suivimodele=new SuiviModele();
			suivimodele.setListphases(phases.get(i));
			for(int j=0;j<activities.size();j++) {
				InfosActivite infos=new InfosActivite();
		        infos.setResponsable(activities.get(j).getResponsable().getNom()+" "+activities.get(j).getResponsable().getPrenom());
		        infos.setImage_responsable("http://localhost:8089/uploads/utilisateurs/"+activities.get(j).getResponsable().getPhoto());
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.FRENCH);
		        Calendar calendar1 = Calendar.getInstance();
				Date firstDate;
				try {
					firstDate = sdf.parse(sdf.format(calendar1.getTime()));
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(activities.get(j).getEcheance());
					Date secondDate = sdf.parse(sdf.format(calendar.getTime()));
					long diffInMillies =  firstDate.getTime()-secondDate.getTime();
					long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
					Locale loc = new Locale("fr", "FR");
					DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
					infos.setDate_echeance(dateFormat.format(activities.get(j).getEcheance()));
					infos.setEspacetravail(activities.get(j).getEspacetravail().getLibelle());
					infos.setStatut(diff);
					infos.setId(activities.get(j).getCode_activite());
					infos.setOrdre(activities.get(j).getOrdre_affichage());
					infos.setMatricule(activities.get(j).getResponsable().getMatricule());
					cible=activities.get(j).getPhasesuivi().getModele().getcible();
					formater = new SimpleDateFormat("EEEE d MMM yyyy");
					
					long diffMillies = activities.get(j).getEcheance().getTime()-cible.getTime();
					long echeance = TimeUnit.DAYS.convert(diffMillies, TimeUnit.MILLISECONDS);
			        infos.setEcheance(echeance);
					infos.setActivite(modelesuiviservice.getActivite(activities.get(j).getActivite_principale()));
					
					infos.setLibelle_statut(activities.get(j).getStatut());
					k2++;
					String statut=infos.getLibelle_statut();
					if( (infos.getLibelle_statut().equals("En cours"))) {
						infos.setColor_statut("bg-c-yellow");
					}else if((diff>0)&&(infos.getLibelle_statut().equals("En attente"))){
						infos.setColor_statut("bg-c-pink");
						infos.setLibelle_statut("En retard");
					}
					else if(infos.getLibelle_statut().equals("En attente")){
						infos.setColor_statut("bg-c-blue");
					}	
					else if(infos.getLibelle_statut().equals("Terminée")) {
						infos.setColor_statut("bg-c-green");
						k1++;
					}
					listinfos.add(infos);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			suivimodele.setActivitesuivi(listinfos);
			listActivities.add(suivimodele);
			listActivities.get(0).setDate_cible(formater.format(cible));
		}
		if(k1==k2) {
			listActivities.get(0).setClotured(true);
			Suivi suivi=new Suivi();
			suivi.setModele(modelesuivi);
			suiviservice.updatesuivi(suivi);
		}
		listActivities.get(0).setCode_modele(modelesuivi.getCode_modele());
	return listActivities;
	}
	@GetMapping("/getSuivi/{id_modele}/{matricule}")
	public List<SuiviModele> getSuivi(@PathVariable long id_modele,@PathVariable String matricule) {
		int size=activitesuiviservice.selectModelesSuiviUser(matricule, id_modele).size()-1;
		ModeleSuivi modelesuivi=activitesuiviservice.selectModelesSuiviUser(matricule, id_modele).get(size);
		return this.selectSuivi(modelesuivi);
	}
	@GetMapping("/filterSuivi/{matricule}/{id_modele}/{year}/{month}")
	public List<SuiviModele> filterSuivi(@PathVariable String matricule,@PathVariable long id_modele,@PathVariable Integer year,@PathVariable Integer month) {
		System.out.println("id:"+id_modele+"year:"+year+"month:"+month);
		
		List<ModeleSuivi> modelessuivi=activitesuiviservice.selectModelesSuiviUser(matricule,id_modele);
		ModeleSuivi modelesuivi=new ModeleSuivi();
		if(modelessuivi.size()>0) {
			for(int i=0;i<modelessuivi.size();i++) {
				Calendar calendar=Calendar.getInstance();
				calendar.setTime(modelessuivi.get(i).getDate_creation());
				Integer year1=calendar.get(Calendar.YEAR);
				Integer month1=calendar.get(Calendar.MONTH)+1;
				if((year1.equals(year))&&(month1.equals(month))) {
					modelesuivi=modelessuivi.get(i);
				}
			}
		}
		
		return this.selectSuivi(modelesuivi);
	}
	@PutMapping("/updatedatecible")
	public void updateDateCible(@RequestBody ModeleSuivi modelesuivi) {
		long diffInMillies =  suiviservice.getModeleSuivi(modelesuivi.getCode_modele()).getcible().getTime()-modelesuivi.getcible().getTime();
		int diff =(int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		System.out.println("diffrence:"+diff);
		suiviservice.updateDateCible(modelesuivi);
		List<PhaseSuivi> listPhasesSuivi=phasesuiviservice.getPhases(modelesuivi.getCode_modele());
		for(int i=0;i<listPhasesSuivi.size();i++) {
			List<ActiviteSuivi> listActivivtesSuivi=activitesuiviservice.getActivities(listPhasesSuivi.get(i).getCode_phase());
			for(int j=0;j<listActivivtesSuivi.size();j++){
				Calendar calendar = Calendar.getInstance();
		        calendar.setTime(listActivivtesSuivi.get(j).getEcheance());
		        calendar.add(Calendar.DATE, diff);
				listActivivtesSuivi.get(j).setEcheance(calendar.getTime());
			}
		}
	}
	@GetMapping("/getModeleSuivi/{id}")
	public ModeleSuivi getModeleSuivi(@PathVariable long id) {
		return suiviservice.getModeleSuivi(id);
	}
	@GetMapping("/getyears")
	public List<Long> getYears() {
		return suiviservice.selectYears();
	}
	@GetMapping("/getModeleSuiviNotif/{id}")
	public List<InfosActivite> getModeleSuivi(@PathVariable String id) {
		
		List<ModeleSuivi> modelessuivi=suiviservice.selectModelesNotifications(activitesuiviservice.selectModelesSuivi(id));
		List<InfosActivite> activites=new ArrayList<InfosActivite>();
		for(int i=0;i<modelessuivi.size();i++) {
			List<PhaseSuivi> phases=phasesuiviservice.getPhases(modelessuivi.get(i).getCode_modele());
			for(int k=0;k<phases.size();k++) {
				List<ActiviteSuivi> activities=activitesuiviservice.getActivities(phases.get(k).getCode_phase());
				for(int j=0;j<activities.size();j++) {
					try {
					if(activities.get(j).getResponsable().getMatricule().equals(id)&&!activities.get(j).getStatut().equals("Terminée")) {
						System.out.println(activities.get(j).getResponsable().getMatricule());
						InfosActivite infos=new InfosActivite();
				        infos.setResponsable(activities.get(j).getResponsable().getNom()+" "+activities.get(j).getResponsable().getPrenom());
				        infos.setImage_responsable("http://localhost:8089/uploads/utilisateurs/"+activities.get(j).getResponsable().getPhoto());
						SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.FRENCH);
				        Calendar calendar1 = Calendar.getInstance();
						Date firstDate;
						SimpleDateFormat formater = null;
						Date cible=null;
							
								firstDate = sdf.parse(sdf.format(calendar1.getTime()));
							
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(activities.get(j).getEcheance());
							Date secondDate = sdf.parse(sdf.format(calendar.getTime()));
							long diffInMillies =  firstDate.getTime()-secondDate.getTime();
							long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
							Locale loc = new Locale("fr", "FR");
							DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
							infos.setDate_echeance(dateFormat.format(activities.get(j).getEcheance()));
							infos.setEspacetravail(modelessuivi.get(i).getLibelle());
							infos.setStatut(diff);
							infos.setId(activities.get(j).getCode_activite());
							infos.setOrdre(activities.get(j).getOrdre_affichage());
							infos.setMatricule(activities.get(j).getResponsable().getMatricule());
							cible=activities.get(j).getPhasesuivi().getModele().getcible();
							formater = new SimpleDateFormat("EEEE d MMM yyyy");
							
							long diffMillies = activities.get(j).getEcheance().getTime()-cible.getTime();
							long echeance = TimeUnit.DAYS.convert(diffMillies, TimeUnit.MILLISECONDS);
					        infos.setEcheance(echeance);
							infos.setActivite(modelesuiviservice.getActivite(activities.get(j).getActivite_principale()));
							
							infos.setLibelle_statut(activities.get(j).getStatut());
							String statut=infos.getLibelle_statut();
							if( (infos.getLibelle_statut().equals("En cours"))) {
								infos.setColor_statut("bg-c-yellow");
							}else if((diff>0)&&(infos.getLibelle_statut().equals("En attente"))){
								infos.setColor_statut("bg-c-pink");
								infos.setLibelle_statut("En retard");
							}
							else if(infos.getLibelle_statut().equals("En attente")){
								infos.setColor_statut("bg-c-blue");
							}	
							else if(infos.getLibelle_statut().equals("Terminée")) {
								infos.setColor_statut("bg-c-green");
							}
							activites.add(infos);
					}
					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		System.out.println(activites.size());
		return activites;
	}
}
