package customers.project.demo.entities;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
@Entity
public class Action implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
private String code;
private String libelle;
@ManyToOne(fetch = FetchType.LAZY)
private Activite activite;
private String description;
@ManyToOne
private EspaceTravail espacetravail;
public String getCode() {
	return code;
}
public void setCode(String code) {
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
private int ordre_affichage;
@Temporal(TemporalType.DATE)
private Date date_creation;
@ManyToOne
private Status status;
@Temporal(TemporalType.DATE)
private Date date_modification;
@Temporal(TemporalType.DATE)
private Date date_suppression;
public EspaceTravail getEspacetravail() {
	return espacetravail;
}
public void setEspacetravail(EspaceTravail espacetravail) {
	this.espacetravail = espacetravail;
}
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}

}
