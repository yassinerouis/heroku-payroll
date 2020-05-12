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
		this.setEcheance(activite.echeance);
		this.setFonction(activite.fonction);
		this.setLibelle(activite.libelle);
		this.setOrdre_affichage(activite.ordre_affichage);
		this.setOrdre_affichage(activite.ordre_affichage);
		this.setVue_ensemble(activite.vue_ensemble);
		this.setPilotage(activite.pilotage);
		this.setPeriodicite(activite.periodicite);
		this.setPrecedente(activite.prerequis);
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
		public Date getDate_suppression() {
			return date_suppression;
		}
		public void setDate_suppression(Date date_suppression) {
			this.date_suppression = date_suppression;
		}
		public Phase getPhase() {
			return phase;
		}
		public void setPhase(Phase phase) {
			this.phase = phase;
		}
	
	private String libelle;
	private String description;
	private String famille;
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
	public String getFamille() {
		return famille;
	}
	public void setFamille(String famille) {
		this.famille = famille;
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
	public String getPeriodicite() {
		return periodicite;
	}
	public void setPeriodicite(String periodicite) {
		this.periodicite = periodicite;
	}
	
	public String getVue_ensemble() {
		return vue_ensemble;
	}
	public void setVue_ensemble(String vue_ensemble) {
		this.vue_ensemble = vue_ensemble;
	}
	
	private String periodicite;
	private String vue_ensemble;
	@Temporal(TemporalType.DATE)
	private Date date_creation;
	@Temporal(TemporalType.DATE)
	private Date date_modification;
	@Temporal(TemporalType.DATE)
	private Date date_suppression;
	@ManyToOne(fetch = FetchType.LAZY)
	private Phase phase;
	@OneToMany
	@JsonIgnore
	private Set<Activite> prerequis;
	public Set<Activite> getPrerequis() {
		return prerequis;
	}
	public void setPrecedente(Set<Activite> prerequis) {
		this.prerequis = prerequis;
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
