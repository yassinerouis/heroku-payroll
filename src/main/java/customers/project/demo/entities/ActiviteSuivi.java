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

public class ActiviteSuivi implements Serializable{
	private static final long serialVersionUID = 1L;
	public ActiviteSuivi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setActivite(ActiviteSuivi activiteSuivi) {
		this.setDescription(activiteSuivi.description);
		this.setEcheance(activiteSuivi.echeance);
		this.setFonction(activiteSuivi.fonction);
		this.setLibelle(activiteSuivi.libelle);
		this.setOrdre_affichage(activiteSuivi.ordre_affichage);
		this.setOrdre_affichage(activiteSuivi.ordre_affichage);
		this.setVue_ensemble(activiteSuivi.vue_ensemble);
		this.setPilotage(activiteSuivi.pilotage);
		this.setPeriodicite(activiteSuivi.periodicite);
		this.setPrecedente(activiteSuivi.precedente);
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code_activite;
	@OneToMany(mappedBy="activite")
	private Set<Commentaire> commentaire=new HashSet<Commentaire>();
	
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
		
		
		public PhaseSuivi getPhase() {
			return phasesuivi;
		}
		public void setPhase(PhaseSuivi phase) {
			this.phasesuivi = phase;
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
	public Set<Commentaire> getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(Set<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}
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
	public int getEcheance() {
		return echeance;
	}
	public void setEcheance(int echeance) {
		this.echeance = echeance;
	}
	public String getVue_ensemble() {
		return vue_ensemble;
	}
	public void setVue_ensemble(String vue_ensemble) {
		this.vue_ensemble = vue_ensemble;
	}
	
	private String periodicite;
	private int echeance;
	private String vue_ensemble;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PhaseSuivi phasesuivi;
	@OneToOne
	@JsonIgnore
	private Activite precedente;
	public Activite getPrecedente() {
		return precedente;
	}
	public void setPrecedente(Activite precedente) {
		this.precedente = precedente;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne
	private Status status;
	@OneToOne
	private Utilisateur responsable;
	private int ordre;
	@OneToOne
	private Suivi suivi;
}
