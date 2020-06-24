package customers.project.demo.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.project.demo.dao.DeviseRepository;
import customers.project.demo.dao.MesureCompositionRepository;
import customers.project.demo.dao.MesureGrapheRepository;
import customers.project.demo.dao.MesureWidgetRepository;
import customers.project.demo.dao.PeriodeRepository;
import customers.project.demo.entities.Dashboard;
import customers.project.demo.entities.Devise;
import customers.project.demo.entities.MesureGraphe;
import customers.project.demo.entities.MesureWidget;
import customers.project.demo.entities.Modele;
import customers.project.demo.entities.Periode;

@Service
public class MesureService {
	@Autowired
	MesureWidgetRepository mesurewidgetrepository;
	@Autowired
	MesureCompositionRepository mesurecompositionrepository;
	@Autowired
	MesureGrapheRepository mesuregrapherepository;
	@Autowired 
	PeriodeRepository perioderepository;
	@Autowired
	DeviseRepository deviserepository;
	public Devise getDevise(int id) {
		return deviserepository.getOne(id);
	}
	public float deviseToDevise(int id_devise_base,int id_devise_final) {
		Devise devise_base=this.getDevise(id_devise_base);
		Devise devise_final=this.getDevise(id_devise_final);
		float montant=devise_base.getValeur_euro()/devise_final.getValeur_euro();
		return montant;
	}
	public Dashboard filterDashboard(Devise devise,Modele modele,Periode periode) {
		Dashboard dashboard=new Dashboard();
		List<MesureWidget> widgets=new ArrayList<MesureWidget>();
		System.out.println(modele.getCode_modele()+" "+periode.getIdentifiant());
		widgets=mesurewidgetrepository.filterDashboarWidget(modele, periode);
		for(int i=0;i<widgets.size();i++) {
			if( ! widgets.get(i).getLibelle().equals("TOTAL EMPLOYEES") && ! widgets.get(i).getLibelle().equals("PROCESSED PAYROLL")){
				double valeur=widgets.get(i).getValeur()*this.deviseToDevise(widgets.get(i).getDevise().getIdentifiant(), devise.getIdentifiant());
				double ancienne_valeur=widgets.get(i).getAncienne_valeur()*this.deviseToDevise(widgets.get(i).getDevise().getIdentifiant(), devise.getIdentifiant());
				widgets.get(i).setAncienne_valeur(ancienne_valeur);
				widgets.get(i).setValeur(valeur);
			}
			System.out.println("w"+widgets.get(i).getValeur());
		}
		dashboard.setWidgets(widgets);
		dashboard.setCompositions(mesurecompositionrepository.filterDashboardComposition(modele, periode.getAnnee()));
		List<MesureGraphe> mg=new ArrayList<MesureGraphe>();
		mg=mesuregrapherepository.filterDashboardGraphe(modele,periode);
		List<MesureGraphe> mesureGrapheList=new ArrayList<MesureGraphe>();
		Calendar calendar=Calendar.getInstance();
				Periode periode1=new Periode();
				periode1.setAnnee(periode.getAnnee());
				periode1.setIdentifiant(periode.getIdentifiant());
				periode1.setMois(periode.getMois());
				for(int j=0;j<8;j++) {
					calendar.set(mg.get(0).getPeriode().getAnnee(), mg.get(0).getPeriode().getMois(), 1);
					calendar.add(Calendar.MONTH, -(j));
					if(calendar.get(Calendar.MONTH)==0) {
						periode1.setMois(12);
						periode1.setAnnee(calendar.get(Calendar.YEAR)-1);
					}else {
						periode1.setMois(calendar.get(Calendar.MONTH));
						periode1.setAnnee(calendar.get(Calendar.YEAR));
					}
					Periode periode2=perioderepository.getPeriode(periode1.getAnnee(), periode1.getMois());
					List<MesureGraphe> mg1=mesuregrapherepository.filterDashboardGraphe(modele,periode2);
					for(int k=0;k<mg1.size();k++) {
						if(!mg1.get(k).getLibelle().equals("PAYROLL CLAIM")){
						double valeur=mg1.get(k).getValeur()*this.deviseToDevise(mg1.get(k).getDevise().getIdentifiant(), devise.getIdentifiant());
						mg1.get(k).setValeur(valeur);
						}
						mesureGrapheList.add(mg1.get(k));
						System.out.println(mg1.get(k).getLibelle()+"-"+mg1.get(k).getValeur());
					}
			}
		dashboard.setGraphes(mesureGrapheList);
		return dashboard;
	}
}
