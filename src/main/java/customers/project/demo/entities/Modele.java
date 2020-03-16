package customers.project.demo.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Modele implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	String code_modele;
	
	public Modele() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setModele(Modele modele) {
		this.setDate_virement(modele.date_virement);
		this.setLibelle(modele.libelle);
		this.setReglementation(modele.reglementation);
		this.setType_paie(modele.type_paie);
	}
	String libelle;
	String reglementation;
	String type_paie;
	int date_virement;
	@Temporal(TemporalType.DATE)
	private Date date_creation;
	@Temporal(TemporalType.DATE)
	private Date date_modification;
	@ManyToOne
	private Frequence frequence;
	public Frequence getFrequence() {
		return frequence;
	}
	public void setFrequence(Frequence frequence) {
		this.frequence = frequence;
	}
	public Set<ResponsabiliteModele> getRespomodele() {
		return respomodele;
	}
	public void setRespomodele(Set<ResponsabiliteModele> respomodele) {
		this.respomodele = respomodele;
	}
	public Set<Suivi> getSuivis() {
		return suivis;
	}
	public void setSuivis(Set<Suivi> suivis) {
		this.suivis = suivis;
	}
	public Set<ModelePhase> getPhase() {
		return phase;
	}
	public void setPhase(Set<ModelePhase> phase) {
		this.phase = phase;
	}
	@OneToMany(mappedBy = "modele")
	@JsonIgnore

	private Set<ResponsabiliteModele> respomodele=new HashSet<ResponsabiliteModele>();
	@OneToMany(mappedBy = "modele")
	@JsonIgnore
	private Set<Suivi> suivis=new HashSet<Suivi>();
	
	public String getCode_modele() {
		return code_modele;
	}
	public void setCode_modele(String code_modele) {
		this.code_modele = code_modele;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getReglementation() {
		return reglementation;
	}
	public void setReglementation(String reglementation) {
		this.reglementation = reglementation;
	}
	public String getType_paie() {
		return type_paie;
	}
	public void setType_paie(String type_paie) {
		this.type_paie = type_paie;
	}
	public int getDate_virement() {
		return date_virement;
	}
	public void setDate_virement(int date_virement) {
		this.date_virement = date_virement;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	public Date getDate_modification() {
		return date_modification;
	}
	public void setDate_modification(Date date_modification) {
		this.date_modification = date_modification;
	}
	public Set<ModelePhase> getPhases() {
		return phase;
	}
	public void setPhases(Set<ModelePhase> phase) {
		this.phase = phase;
	}
	public Date getDate_suppression() {
		return date_suppression;
	}
	public void setDate_suppression(Date date_suppression) {
		this.date_suppression = date_suppression;
	}
	public Set<PopulationModele> getPopulations() {
		return populations;
	}
	public void setPopulations(Set<PopulationModele> populations) {
		this.populations = populations;
	}
	@OneToMany(mappedBy = "modele")
	@JsonIgnore
	private Set<ModelePhase> phase=new HashSet<ModelePhase>();
	@Temporal(TemporalType.DATE)
	private Date date_suppression;
	@OneToMany(mappedBy = "modele")
	private Set<PopulationModele> populations=new HashSet<PopulationModele>();
}
