package customers.project.demo.entities;

import java.util.List;

public class SuiviModele {
	PhaseSuivi listphases;
	List<InfosActivite> activitesinfos;
	public PhaseSuivi getListphases() {
		return listphases;
	}
	public void setListphases(PhaseSuivi listphases) {
		this.listphases = listphases;
	}
	public SuiviModele(PhaseSuivi listphases, List<InfosActivite> activitesinfos) {
		super();
		this.listphases = listphases;
		this.activitesinfos = activitesinfos;
	}
	public List<InfosActivite> getActivitesuivi() {
		return activitesinfos;
	}
	public void setActivitesuivi(List<InfosActivite> activitesuivi) {
		this.activitesinfos = activitesuivi;
	}
	public SuiviModele() {
		super();
		// TODO Auto-generated constructor stub
	}

}
