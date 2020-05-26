package customers.project.demo.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Phase implements Serializable{
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

	public Set<Activite> getActivite() {
		return activite;
	}

	public void setActivite(Set<Activite> activite) {
		this.activite = activite;
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
	@ManyToOne
	private Status status;
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
	
	@OneToMany(mappedBy = "phase")
	@JsonIgnore
	private Set<Activite> activite=new HashSet<Activite>();
	
	
}
