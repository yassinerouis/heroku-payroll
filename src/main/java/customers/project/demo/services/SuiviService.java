package customers.project.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.ActiviteRepository;
import customers.project.demo.dao.SuiviRepository;
import customers.project.demo.entities.Activite;
import customers.project.demo.entities.ModeleSuivi;
import customers.project.demo.entities.Suivi;

@Service
@Transactional
public class SuiviService {
@Autowired
SuiviRepository suivirepository;
public void savesuivi(Suivi suivi) {
	suivirepository.save(suivi);
}
public List<ModeleSuivi> getsuivi() {
	return suivirepository.selectModele();
}
}
