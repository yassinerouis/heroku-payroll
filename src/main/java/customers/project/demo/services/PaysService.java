package customers.project.demo.services;

import java.util.Date;
import java.util.List;

import javax.transPays.TransPaysal;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.PaysRepository;
import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.dao.EspaceTravailRepository;
import customers.project.demo.dao.StatusRepository;
import customers.project.demo.entities.Pays;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.EspaceTravail;
import customers.project.demo.entities.Status;

@Service
@Transactional
public class PaysService {
@Autowired
PaysRepository paysrepository;
@Autowired
ActiviteRepository activiterepository;

@Autowired
StatusRepository statusrepository;
	public Pays addPays(Pays pays) {
			return paysrepository.save(pays);
		}

public List<Pays> getPays() {
	return paysrepository.findAll();
}
public void updatePays(Pays pays) {
	paysrepository.getOne(pays.getCode()).setLibelle(pays.getLibelle());
	paysrepository.getOne(pays.getCode()).setReglementation(pays.getReglementation());
	paysrepository.getOne(pays.getCode()).setLogo(pays.getLogo());
}
public void deletePays(int id) {
	paysrepository.deleteById(id);
}
}
