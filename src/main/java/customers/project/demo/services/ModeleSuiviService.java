package customers.project.demo.services;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.dao.ModeleSuiviRepository;
import customers.project.demo.dao.PhaseSuiviRepository;
import customers.project.demo.dao.PopulationRepository;
import customers.project.demo.dao.ResponsabiliteModeleSuiviRepository;
import customers.project.demo.dao.TypePopulationRepository;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.ModeleSuivi;
import customers.project.demo.entities.PhaseSuivi;
import customers.project.demo.entities.Population;
import customers.project.demo.entities.ResponsabiliteModeleSuivi;
import customers.project.demo.entities.TypePopulation;


@Service
@Transactional

public class ModeleSuiviService {
	@Autowired
	PhaseSuiviRepository phasesuivirepository;
	@Autowired
	TypePopulationRepository typepoprepository;
	@Autowired
	ModeleSuiviRepository ModeleSuivirepository;
	@Autowired
	ResponsabiliteModeleSuiviRepository responsabiliteModeleSuivirepository;
	@Autowired
	PopulationRepository populationrepository;
	@Autowired
	ActiviteRepository activiterepository;
	public ModeleSuivi addModeleSuivi(ModeleSuivi ModeleSuivi) {
		return ModeleSuivirepository.save(ModeleSuivi);
	}
	
	
	public List<ModeleSuivi> getModeleSuivis() {
		return ModeleSuivirepository.findAll();
	}
	public ModeleSuivi updateModeleSuivi(ModeleSuivi ModeleSuivi,int type) {
		ModeleSuivirepository.getOne(ModeleSuivi.getCode_modele()).setModele(ModeleSuivi);
		return ModeleSuivirepository.getOne(ModeleSuivi.getCode_modele());
	}
	public ModeleSuivi getModeleSuivi(long id) {
		return ModeleSuivirepository.getOne(ModeleSuivirepository.getModele(id));
	}
	public void deleteModeleSuivi(long id) {
		ModeleSuivi ModeleSuivi=ModeleSuivirepository.getOne(id);
		List<ResponsabiliteModeleSuivi> listresponsables=responsabiliteModeleSuivirepository.findAll();
		for(int i =0 ;i<listresponsables.size();i++) {
			if(listresponsables.get(i).getModeleSuivi()==ModeleSuivi) {
				responsabiliteModeleSuivirepository.delete(listresponsables.get(i));
			}
		}
		ModeleSuivirepository.deleteById(id);
	}
	
	public Set<Population> getPopulations(long ModeleSuivi) {
		TypePopulation population=ModeleSuivirepository.getOne(ModeleSuivi).getTypepopulation();
		return populationrepository.findPopulations(population.getIdentifiant());
	}
	
	public List<ModeleSuivi> selectModeleSuivis(long modele) {
		return ModeleSuivirepository.SelectModeleSuivi(modele);
	}
	public Activite getActivite(long activite) {
		return activiterepository.getOne(activite);
	}
}

