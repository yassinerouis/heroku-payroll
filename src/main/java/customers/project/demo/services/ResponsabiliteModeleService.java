package customers.project.demo.services;

import java.util.Date;

import javax.transaction.Transactional;

import customers.project.demo.dao.ResponsabiliteModeleRepository;
import customers.project.demo.dao.UtilisateurRepository;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ResponsabiliteModele;
import customers.project.demo.entities.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ResponsabiliteModeleService {
@Autowired
private ResponsabiliteModeleRepository responsabilitemodelerepository;

@Autowired
private UtilisateurRepository userrepository;

public void addResponsabilite(String responsable,Modele modele) {
	ResponsabiliteModele responsabilitemodele=new ResponsabiliteModele();
	Date date_debut= new Date();
	responsabilitemodele.setDate_debut(date_debut);
	
	Utilisateur utilisateur=userrepository.getOne(responsable);
	responsabilitemodele.setModele(modele);
	responsabilitemodele.setPayrollmanager(utilisateur);
	responsabilitemodelerepository.save(responsabilitemodele);
}

public ResponsabiliteModele getResponsable(long modele) {
	return responsabilitemodelerepository.selectResponsabilite(modele);
}


public void updateResponsabilite(Modele modele,String responsable) {
	if(!responsabilitemodelerepository.selectResponsabilite(modele.getCode_modele()).getPayrollmanager().getMatricule().equals(responsable)) {
		ResponsabiliteModele responsabilitemodele=new ResponsabiliteModele();
		Date date= new Date();
		responsabilitemodelerepository.selectResponsabilite(modele.getCode_modele()).setDate_fin(date);
		responsabilitemodele.setDate_debut(date);
		Utilisateur utilisateur=userrepository.getOne(responsable);
		responsabilitemodele.setModele(modele);
		responsabilitemodele.setPayrollmanager(utilisateur);
		responsabilitemodelerepository.save(responsabilitemodele);
	}
}
}
