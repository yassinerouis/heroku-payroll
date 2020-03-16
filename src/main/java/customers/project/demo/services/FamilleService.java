package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.FamilleRepository;
import customers.project.demo.entities.Famille;
	@Service
	@Transactional
	public class FamilleService {
		@Autowired
		FamilleRepository Famillerepository;
		public Famille addFamille(Famille Famille) {
			return Famillerepository.save(Famille);
		}
		public List<Famille> getFamille() {
			return Famillerepository.findAll();
		}
		public void updateFamille(Famille Famille) {
			Famillerepository.getOne(Famille.getIdentifiant()).
			setLibelle(Famille.getLibelle());
			Famillerepository.getOne(Famille.getIdentifiant()).setDescription(Famille.getDescription());
		}
		public void deleteFamille(Integer id) {
			Famillerepository.deleteById(id);
		}
	}
