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
import customers.project.demo.entities.Suivi;

@Service
@Transactional
public class SuiviService {
@Autowired
SuiviRepository suivirepository;
@Autowired
ActiviteRepository activiterepository;
public void savesuivi(Suivi suivi) {
	Date date_creation= new Date();
	suivi.setDate_creation(date_creation);
	suivirepository.save(suivi);
}
}
