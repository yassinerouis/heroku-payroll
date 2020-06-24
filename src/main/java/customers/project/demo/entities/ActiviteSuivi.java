package customers.project.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

public class ActiviteSuivi implements Serializable{
	private static final long serialVersionUID = 1L;
	public ActiviteSuivi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setActivite(ActiviteSuivi activiteSuivi,Activite activite) {
		this.setDescription(activite.getDescription());
		this.setEcheance(activiteSuivi.date_echeance);
		this.setFonction(activite.getFonction());
		this.setLibelle(activite.getLibelle());
		this.setOrdre_affichage(activiteSuivi.ordre_affichage);
		this.setResponsable(activiteSuivi.responsable);
		this.setPilotage(activite.isPilotage());
		this.setPeriodicite(activite.getFrequence());
		this.setEspacetravail(activite.getEspacetravail());
	}
	public void setActiviteModele(ModeleActivite activite) {
		this.setDescription(activite.getActivite().getDescription());
		this.setFonction(activite.getActivite().getFonction());
		this.setLibelle(activite.getActivite().getLibelle());
		this.setOrdre_affichage(activite.getOrdre());
		this.setPilotage(activite.getActivite().isPilotage());
		this.setPeriodicite(activite.getActivite().getFrequence());
		this.setMode_activite(activite.getActivite().getMode_activite());
		this.setEspacetravail(activite.getActivite().getEspacetravail());
	}
	public void setActiviteX(Activite activite) {
		this.setDescription(activite.getDescription());
		this.setFonction(activite.getFonction());
		this.setLibelle(activite.getLibelle());
		this.setPilotage(activite.isPilotage());
		this.setPeriodicite(activite.getFrequence());
		this.setMode_activite(activite.getMode_activite());
		this.setEspacetravail(activite.getEspacetravail());
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
		public PhaseSuivi getPhase() {
			return phasesuivi;
		}
		public void setPhase(PhaseSuivi phase) {
			this.phasesuivi = phase;
		}
	private long activite_principale;
	private String libelle;
	public long getActivite_principale() {
		return activite_principale;
	}
	public void setActivite_principale(long activite_principale) {
		this.activite_principale = activite_principale;
	}
	private String description;
	private String famille;
	private boolean pilotage;
	private String fonction;
	private String statut;
	private String mode_activite;
	private int ordre_affichage;
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
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
	
	public Frequence getPeriodicite() {
		return periodicite;
	}
	public void setPeriodicite(Frequence periodicite) {
		this.periodicite = periodicite;
	}
	public Date getEcheance() {
		return date_echeance;
	}
	public void setEcheance(Date echeance) {
		this.date_echeance = echeance;
	}
	public String getVue_ensemble() {
		return vue_ensemble;
	}
	public void setVue_ensemble(String vue_ensemble) {
		this.vue_ensemble = vue_ensemble;
	}
	@ManyToOne
	private Frequence periodicite;
	@Temporal(TemporalType.DATE)
	private Date date_echeance;
	private String vue_ensemble;
	@ManyToOne(fetch = FetchType.LAZY)
	private PhaseSuivi phasesuivi;
	@ManyToMany
	@JsonIgnore
	private Set<ActiviteSuivi> prerequis;
	public PhaseSuivi getPhasesuivi() {
		return phasesuivi;
	}
	public void setPhasesuivi(PhaseSuivi phasesuivi) {
		this.phasesuivi = phasesuivi;
	}
	public Set<ActiviteSuivi> getPrerequis() {
		return prerequis;
	}
	public void setPrerequis(Set<ActiviteSuivi> prerequis) {
		this.prerequis = prerequis;
	}
	public Utilisateur getResponsable() {
		return responsable;
	}
	public void setResponsable(Utilisateur responsable) {
		this.responsable = responsable;
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	public Suivi getSuivi() {
		return suivi;
	}
	public void setSuivi(Suivi suivi) {
		this.suivi = suivi;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@ManyToOne
	private Status status;
	@ManyToOne
	private Utilisateur responsable;
	private int ordre;
	@OneToOne
	private Suivi suivi;
}
