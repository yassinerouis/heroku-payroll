package customers.project.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Activite implements Serializable{
	private static final long serialVersionUID = 1L;
	public Activite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setActivite(Activite activite) {
		this.setDescription(activite.description);
		this.setFonction(activite.fonction);
		this.setLibelle(activite.libelle);
		this.setOrdre_affichage(activite.ordre_affichage);
		this.setPilotage(activite.pilotage);
		this.setMode_activite(activite.mode_activite);
		this.setFrequence(activite.frequence);
		this.setStatus(activite.status);
		this.setPrecedente(activite.prerequis);
		this.setPhase(activite.phase);
		this.setResponsable(activite.responsable);
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code_activite;
	
	
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Phase getPhase() {
			return phase;
		}
		public void setPhase(Phase phase) {
			this.phase = phase;
		}
	private String libelle;
	private String description;
	private boolean pilotage;
	private String fonction;
	private String mode_activite;
	private int ordre_affichage;
	@ManyToOne
	private EspaceTravail espacetravail;
	
	public EspaceTravail getEspacetravail() {
		return espacetravail;
	}
	public void setEspacetravail(EspaceTravail espacetravail) {
		this.espacetravail = espacetravail;
	}
	public long getCode_activite() {
		return code_activite;
	}
	public void setCode_activite(long code_activite) {
		this.code_activite = code_activite;
	}
	
	public boolean isPilotage() {
		return pilotage;
	}
	public void setPilotage(boolean pilotage) {
		this.pilotage = pilotage;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getMode_activite() {
		return mode_activite;
	}
	public void setMode_activite(String mode_activite) {
		this.mode_activite = mode_activite;
	}
	public int getOrdre_affichage() {
		return ordre_affichage;
	}
	public void setOrdre_affichage(int ordre_affichage) {
		this.ordre_affichage = ordre_affichage;
	}
	
	public Frequence getFrequence() {
		return frequence;
	}
	public void setFrequence(Frequence frequence) {
		this.frequence = frequence;
	}
	public void setPrerequis(Set<Activite> prerequis) {
		this.prerequis = prerequis;
	}

	@ManyToOne
	private Frequence frequence;
	@ManyToOne
	private Phase phase;
	@ManyToMany
	@JsonIgnore
	private Set<Activite> prerequis;
	public Set<Activite> getPrerequis() {
		return prerequis;
	}
	public void setPrecedente(Set<Activite> prerequis) {
		this.prerequis = prerequis;
	}
private String responsable;
	public String getResponsable() {
	return responsable;
}
public void setResponsable(String responsable) {
	this.responsable = responsable;
}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne
	private Status status;
}
