package customers.project.demo.services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import customers.project.demo.dao.DeviseRepository;
import customers.project.demo.entities.Devise;

@Service
@Transactional
public class DeviseService {
@Autowired
DeviseRepository deviserepository;
public Devise getDevise(int id) {
	return deviserepository.getOne(id);
}
public List<Devise> getAll(){
	return deviserepository.findAll();
}
public float deviseToDevise(int id_devise_base,int id_devise_final) {
	Devise devise_base=this.getDevise(id_devise_base);
	Devise devise_final=this.getDevise(id_devise_final);
	float montant=devise_base.getValeur_euro()/devise_final.getValeur_euro();
	return montant;
}
public Devise getDevisePays(int pays) {
System.out.println(pays+"+"+deviserepository.getDevise(pays).getSymbol());
	return deviserepository.getDevise(pays);
}
}
