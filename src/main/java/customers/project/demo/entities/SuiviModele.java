package customers.project.demo.entities;

import java.util.List;

public class SuiviModele {
	PhaseSuivi listphases;
	List<Long> years;
	List<Modele> modeles;
	public List<Long> getYears() {
		return years;
	}
	public void setYears(List<Long> years) {
		this.years = years;
	}
	public List<Modele> getModeles() {
		return modeles;
	}
	public void setModeles(List<Modele> modeles) {
		this.modeles = modeles;
	}
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
	String date_cible;
	
	public String getDate_cible() {
		return date_cible;
	}
	public void setDate_cible(String date_cible) {
		this.date_cible = date_cible;
	}
	private boolean clotured;
	
	public boolean isClotured() {
		return clotured;
	}
	public void setClotured(boolean clotured) {
		this.clotured = clotured;
	}
	long code_modele;
	public List<InfosActivite> getActivitesinfos() {
		return activitesinfos;
	}
	public void setActivitesinfos(List<InfosActivite> activitesinfos) {
		this.activitesinfos = activitesinfos;
	}
	public long getCode_modele() {
		return code_modele;
	}
	public void setCode_modele(long code_modele) {
		this.code_modele = code_modele;
	}

}
