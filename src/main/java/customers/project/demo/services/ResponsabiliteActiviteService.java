package customers.project.demo.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ResponsabiliteActiviteRepository;
import customers.project.demo.dao.ResponsabiliteActiviteRepository;
import customers.project.demo.dao.UtilisateurRepository;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.ResponsabiliteActivite;
import customers.project.demo.entities.ResponsabiliteActivite;
import customers.project.demo.entities.Utilisateur;

@Service
@Transactional
public class ResponsabiliteActiviteService {
@Autowired
private ResponsabiliteActiviteRepository responsabiliteactiviterepository;

@Autowired
private UtilisateurRepository userrepository;

public void addResponsabilite(String responsable,Activite activite) {
	ResponsabiliteActivite responsabiliteActivite=new ResponsabiliteActivite();
	Date date_debut= new Date();
		Utilisateur utilisateur=userrepository.getOne(responsable);
		responsabiliteActivite.setActivite(activite);
		responsabiliteActivite.setPayroll(utilisateur);
		responsabiliteActivite.setDate_debut(date_debut);
		responsabiliteactiviterepository.save(responsabiliteActivite);
}

public List<ResponsabiliteActivite> getResponsables(long Activite) {
	return responsabiliteactiviterepository.selectResponsabilites(Activite);
}


public void updateResponsabilite(Activite Activite,String responsable) {
	List<ResponsabiliteActivite> respos=responsabiliteactiviterepository.selectResponsabilites(Activite.getCode_activite());
int trouve=0;
	for(int  i=0;i<respos.size();i++) {
		
	trouve=0;
	if(respos.get(i).getPayroll().getMatricule()==responsable) {
		trouve=1;
	}
	if(trouve==1) {
		ResponsabiliteActivite responsabiliteActivite=new ResponsabiliteActivite();
		Date date= new Date();
		responsabiliteactiviterepository.selectResponsabilites(Activite.getCode_activite()).get(i).setDate_fin(date);
		responsabiliteActivite.setDate_debut(date);
		Utilisateur utilisateur=userrepository.getOne(responsable);
		responsabiliteActivite.setActivite(Activite);
		responsabiliteActivite.setPayroll(utilisateur);
		responsabiliteactiviterepository.save(responsabiliteActivite);
		}
	}
}
}