package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.TypePaieRepository;
import customers.project.demo.entities.TypePaie;
@Service
@Transactional
public class TypePaieService {

	
		@Autowired
		TypePaieRepository typepaierepository;
		public TypePaie addtypepaie(TypePaie typepaie) {
			return typepaierepository.save(typepaie);
		}
		public List<TypePaie> gettypepaie() {
			return typepaierepository.findAll();
		}
		public void updatetypepaie(TypePaie typepaie) {
			typepaierepository.getOne(typepaie.getIdentifiant()).
			setLibelle(typepaie.getLibelle());
			typepaierepository.getOne(typepaie.getIdentifiant()).setDescription(typepaie.getDescription());
		}
		public void deletetypepaie(Integer id) {
			typepaierepository.deleteById(id);
		}
	}


