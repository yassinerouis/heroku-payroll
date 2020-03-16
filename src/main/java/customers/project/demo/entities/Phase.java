package customers.project.demo.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Phase implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	String code_phase;
	
	public String getCode_phase() {
		return code_phase;
	}

	public void setCode_phase(String code_phase) {
		this.code_phase = code_phase;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public Set<Activite> getActivite() {
		return activite;
	}

	public void setActivite(Set<Activite> activite) {
		this.activite = activite;
	}

	public Set<ModelePhase> getModele() {
		return modele;
	}

	public Phase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setPhase(Phase phase) {
		this.setDescription(phase.description);
		this.setLibelle(phase.libelle);
	}
	String libelle;
	String description;
	@ManyToOne
	private Famille famille;
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	@Temporal(TemporalType.DATE)
	private Date date_creation;
	@Temporal(TemporalType.DATE)
	private Date date_modification;
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	public Set<ModelePhase> getModeles() {
		return modele;
	}
	public void setModele(Set<ModelePhase> modele) {
		this.modele = modele;
	}
	public Date getDate_suppression() {
		return date_suppression;
	}
	public void setDate_suppression(Date date_suppression) {
		this.date_suppression = date_suppression;
	}
	@OneToMany(mappedBy = "phase")
	@JsonIgnore
	private Set<ModelePhase> modele=new HashSet<ModelePhase>();
	@OneToMany(mappedBy = "phase")
	@JsonIgnore
	private Set<Activite> activite=new HashSet<Activite>();
	@Temporal(TemporalType.DATE)
	private Date date_suppression;
	
}
