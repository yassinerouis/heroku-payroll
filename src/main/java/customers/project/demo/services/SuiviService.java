package customers.project.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.dao.ModeleSuiviRepository;
import customers.project.demo.dao.SuiviRepository;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.ModeleSuivi;
import customers.project.demo.entities.Suivi;

@Service
@Transactional
public class SuiviService {
@Autowired
SuiviRepository suivirepository;
@Autowired
ModeleSuiviRepository modelesuivirepository;
public void savesuivi(Suivi suivi) {
	suivirepository.save(suivi);
}
public List<ModeleSuivi> getsuivi() {
	return suivirepository.selectModele();
}
public void updateDateCible(ModeleSuivi modelesuivi) {
	 modelesuivirepository.getOne(modelesuivi.getCode_modele()).setcible(modelesuivi.getcible());
}
public ModeleSuivi getModeleSuivi(long modelesuivi) {
	return modelesuivirepository.getOne(modelesuivi);
}
public void updatesuivi(Suivi suivi) {
	System.out.println(suivi.getModele().getCode_modele());
	suivirepository.updateSuivi(true, suivi.getModele().getCode_modele());
}
public Suivi selectSuivi(long modele) {
	return suivirepository.selectSuivi(modele);
}
public List<Long> selectYears(){
	return suivirepository.selectYears();
}
public List<ModeleSuivi> selectModelesNotifications(List<Long> modeles){
	return suivirepository.selectModelesSuivi(modeles);
}
} 
