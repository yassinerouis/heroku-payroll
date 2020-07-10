package customers.project.demo.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.dao.ActiviteSuiviRepository;
import customers.project.demo.dao.EspaceTravailRepository;
import customers.project.demo.dao.ModeleSuiviRepository;
import customers.project.demo.dao.PhaseRepository;
import customers.project.demo.dao.PhaseSuiviRepository;
import customers.project.demo.dao.ResponsabiliteActiviteRepository;
import customers.project.demo.dao.StatusRepository;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.ActiviteSuivi;
import customers.project.demo.entities.EspaceTravail;
import customers.project.demo.entities.InfosActivite;
import customers.project.demo.entities.Phase;
import customers.project.demo.entities.PhaseSuivi;
import customers.project.demo.entities.ResponsabiliteActivite;
import customers.project.demo.entities.Status;

@Service
@Transactional

public class ActiviteSuiviService {
	@Autowired
    public JavaMailSender emailSender;
	@Autowired
	ModeleSuiviRepository modelesuivirepository;
	@Autowired
	ActiviteRepository activiterepository;
	@Autowired
	ActiviteSuiviRepository activiteSuivirepository;
	@Autowired
	StatusRepository statusrepository;
	@Autowired
	EspaceTravailRepository espacetravailrepository;
	@Autowired
	PhaseSuiviRepository phasesuivirepository;
	@Autowired
	ResponsabiliteActiviteRepository responsabiliteactiviterepository;
public ActiviteSuivi addactiviteSuivi(ActiviteSuivi activiteSuivi) {
	return activiteSuivirepository.save(activiteSuivi);
	}
public ActiviteSuivi addFirstactiviteSuivi(ActiviteSuivi activiteSuivi,int id_status,long id_phase,int id_espacetravail) {
	PhaseSuivi phase=phasesuivirepository.getOne(id_phase);
	EspaceTravail espacetravail=espacetravailrepository.getOne(id_espacetravail);
		Status status=statusrepository.getOne(id_status);
		activiteSuivi.setPhase(phase);
		activiteSuivi.setStatus(status);
		ActiviteSuivi act=activiteSuivirepository.save(activiteSuivi);
		phase.getActivite().add(activiteSuivi);
		activiteSuivi.setEspacetravail(espacetravail);
		return act;
	}

public ActiviteSuivi getactiviteSuivi(Long id) {
	return activiteSuivirepository.getOne(id);
}

public List<ActiviteSuivi> getactiviteSuivis() {
	return activiteSuivirepository.findAll();
}
public Set<ActiviteSuivi> getPrerequis(long id_activiteSuivi) {
	return activiteSuivirepository.getOne(id_activiteSuivi).getPrerequis();
}
/*public List<ActiviteSuivi> selectactiviteSuivis(Long id_phase) {
	PhaseSuivi phase=phasesuivirepository.getOne(id_phase);
	return activiteSuivirepository.selectPhases(phase);
}*/
public void updateactiviteSuivi(ActiviteSuivi activiteSuivi,int echeance) {
	ActiviteSuivi activitesuivi=activiteSuivirepository.getOne(activiteSuivi.getCode_activite());
	if(!activiteSuivi.getResponsable().getMatricule().equals(activitesuivi.getResponsable().getMatricule())) {
		ResponsabiliteActivite responsabilite=new ResponsabiliteActivite();
		responsabilite.setActivite(activitesuivi);
		responsabilite.setPayroll(activitesuivi.getResponsable());
		Date date=new Date();
		responsabilite.setDate_fin(date);
		responsabiliteactiviterepository.save(responsabilite);
	}
	Date date=activitesuivi.getPhasesuivi().getModele().getcible();
	Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, echeance);
    activiteSuivi.setEcheance(calendar.getTime());
	Activite activite=activiterepository.getOne(activitesuivi.getActivite_principale());
	activiteSuivirepository.getOne(activiteSuivi.getCode_activite()).setActivite(activiteSuivi,activite);
}
public void updateactiviteStatut(ActiviteSuivi activiteSuivi,String statut) {
	activiteSuivirepository.getOne(activiteSuivi.getCode_activite()).setStatut(statut);
}
public List<ActiviteSuivi> getActivities(long phase){
	System.out.println(phase);
	return activiteSuivirepository.getActivities(phase);
}
public void delete(long id) {
	activiteSuivirepository.deleteById(id);
}
public void sendEmail(InfosActivite activite) {
	try {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("rouissi.yassine.97@gmail.com");
        message.setSubject("Relance de l'activité "+activite.getActivite().getLibelle());
        long statut=activite.getStatut();
        String contenu;
        if(statut>0){
            contenu="La date d'écheance de l'activité "+activite.getActivite().getLibelle()+" s'est terminée il y a "+statut +" jours";
          }else if(statut<0){
            contenu="Il reste encore  "+statut +" jours pour la date d'écheance de l'activité "+activite.getActivite().getLibelle();
          }else{
            contenu="La date d'écheance de l'activité "+activite.getActivite().getLibelle()+" est aujourd'hui";
          }
        Date date=new Date();
        int h=date.getHours();
        if(statut==0) {
        	message.setText("Bonsoir "+activite.getResponsable()+", "+"\n"+contenu+"."+"\n"+"Cordialement,");
        }
        if(h>17 && statut!=0) {
        	message.setText("Bonsoir "+activite.getResponsable()+", "+"\n"+contenu+"."+"\n"+"La date d'echeance:"+activite.getDate_echeance()+"."+"\n"+"Cordialement,");
        }else if(h<17 && statut!=0) {
        	message.setText("Bonjour "+activite.getResponsable()+", "+"\n"+contenu+"."+"\n"+"La date d'echeance:"+activite.getDate_echeance()+"."+"\n"+"Cordialement,");
        }
        // Send Message!
        this.emailSender.send(message);

	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	  
}
/*
public Set<ActiviteSuivi> setPrerequis(Set<Activite> prerequis) {
	
}*/
/*
public void deleteactiviteSuivi(long id) {
	for(int i=0;i<this.getactiviteSuivis().size();i++) {
		for(int j=0;j<this.getactiviteSuivis().get(i).getPrerequis().size();j++) {
			List<activiteSuivi> list = new ArrayList<activiteSuivi>(this.getactiviteSuivis().get(i).getPrerequis());
			if(list.get(j).getCode_activiteSuivi()==id) {
				this.getactiviteSuivis().get(i).getPrerequis().remove(activiteSuivirepository.getOne(id));
			}
		}
	}
	activiteSuivirepository.getOne(id).setPrecedente(null);
	activiteSuivirepository.save(activiteSuivirepository.getOne(id));
	activiteSuivirepository.deleteById(id);
}*/
public List<Long> selectModeles(String matricule){
	List<Long> phases_id=new ArrayList<Long>();
	for(int i=0;i<this.activiteSuivirepository.SelectPhasesSuivi(matricule).size();i++) {
		phases_id.add(this.activiteSuivirepository.SelectPhasesSuivi(matricule).get(i).getCode_phase());
	}
	List<Long> modeles_id=new ArrayList<Long>();
	for(int i=0;i<this.phasesuivirepository.SelectModelesSuivi(phases_id).size();i++) {
		modeles_id.add(this.phasesuivirepository.SelectModelesSuivi(phases_id).get(i).getCode_modele());
	}
	List<Long> modeles=new ArrayList<Long>();
	for(int i=0;i<this.modelesuivirepository.SelectModeles(modeles_id).size();i++) {
		modeles.add(this.modelesuivirepository.SelectModeles(modeles_id).get(i));
		System.out.println(modeles.get(i));
	}
	return modeles;
}
}
