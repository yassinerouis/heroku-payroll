package customers.project.demo.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Action implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private long code;
private String libelle;

@ManyToOne(cascade = CascadeType.MERGE)
private Activite activite;

private String description;

@ManyToOne(cascade = CascadeType.MERGE)
private EspaceTravail espacetravail;

public EspaceTravail getEspacetravail() {
	return espacetravail;
}
public void setEspacetravail(EspaceTravail espacetravail) {
	this.espacetravail = espacetravail;
}
public long getCode() {
	return code;
}
public void setCode(long code) {
	this.code = code;
}
public Action() {
	super();
	// TODO Auto-generated constructor stub
}
public void setAction(Action action) {
	this.setLibelle(action.libelle);
	this.setDescription(action.description);
	this.setOrdre_affichage(action.ordre_affichage);
	this.setStatus(action.status);
	this.setEspacetravail(action.espacetravail);
	this.setActivite(action.activite);
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public Activite getActivite() {
	return activite;
}
public void setActivite(Activite activite) {
	this.activite = activite;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getOrdre_affichage() {
	return ordre_affichage;
}
public void setOrdre_affichage(int ordre_affichage) {
	this.ordre_affichage = ordre_affichage;
}

private int ordre_affichage;

@ManyToOne(cascade = CascadeType.MERGE)
private Status status;


public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}

}
