package customers.project.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.PeriodeRepository;
import customers.project.demo.entities.Periode;

@Service
@Transactional
public class PeriodeService {
@Autowired
PeriodeRepository perioderepository;
public Periode getPeride(int annee,int mois) {
	System.out.println(annee+"/"+mois);
	return perioderepository.getPeriode(annee, mois);
}
}
