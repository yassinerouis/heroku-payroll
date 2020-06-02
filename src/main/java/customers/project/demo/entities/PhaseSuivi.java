package customers.project.demo.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class PhaseSuivi implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	long code_phase;
	public long getCode_phase() {
		return code_phase;
	}
	public void setCode_phase(long code_phase) {
		this.code_phase = code_phase;
	}
	public Famille getFamille() {
		return famille;
	}
	public void setFamille(Famille famille) {
		this.famille = famille;
	}
	public Set<ActiviteSuivi> getActivite() {
		return activite;
	}
	public void setActivite(Set<ActiviteSuivi> activite) {
		this.activite = activite;
	}
	public PhaseSuivi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setPhase(PhaseSuivi phase) {
		this.setDescription(phase.description);
		this.setLibelle(phase.libelle);
		this.setFamille(phase.famille);
	}
	public void setPhaseModele(Phase phase) {
		this.setDescription(phase.getDescription());
		this.setLibelle(phase.getLibelle());
		this.setFamille(phase.getFamille());
	}
	String libelle;
	String description;
	@ManyToOne
	private Famille famille;
	@ManyToOne(cascade=CascadeType.ALL)
	
	private ModeleSuivi modelesuivi;
	public ModeleSuivi getModele() {
		return modelesuivi;
	}
	public void setModele(ModeleSuivi modele) {
		this.modelesuivi = modele;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@OneToMany(mappedBy = "phasesuivi")
	@JsonIgnore
	private Set<ActiviteSuivi> activite=new HashSet<ActiviteSuivi>();
}
