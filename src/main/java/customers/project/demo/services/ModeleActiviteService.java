package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ModeleActiviteRepository;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.ModeleActivite;

@Service
@Transactional
public class ModeleActiviteService {
	@Autowired
	ModeleActiviteRepository modeleactiviterepository;
	public void saveModeleActivite(ModeleActivite modeleactivite){
		modeleactiviterepository.save(modeleactivite);
	}
	public List<ModeleActivite> selectModeleActivities(Modele modele){
		return modeleactiviterepository.selectActivities(modele.getCode_modele());
	}
}
