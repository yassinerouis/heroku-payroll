package customers.project.demo.entities;


import java.io.Serializable;
import java.util.Date;
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
@Entity
public class ActionSuivi implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private long code;
private String libelle;
@ManyToOne(fetch = FetchType.LAZY)
private ActiviteSuivi activite;
private String description;

public long getCode() {
	return code;
}
public void setCode(long code) {
	this.code = code;
}
public ActionSuivi() {
	super();
	// TODO Auto-generated constructor stub
}
public void setAction(ActionSuivi actionSuivi) {
	this.setLibelle(actionSuivi.libelle);
	this.setDescription(actionSuivi.description);
	this.setOrdre_affichage(actionSuivi.ordre_affichage);
	this.setStatus(actionSuivi.status);
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public ActiviteSuivi getActivite() {
	return activite;
}
public void setActivite(ActiviteSuivi activite) {
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

@ManyToOne
private Status status;


public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}

}
