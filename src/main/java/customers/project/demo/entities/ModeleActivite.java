package customers.project.demo.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class ModeleActivite implements Serializable{
private static final long serialVersionUID = 1L;
@javax.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;
public Long getId() {
	return id;
}
int ordre;
public int getOrdre() {
	return ordre;
}
public void setOrdre(int ordre) {
	this.ordre = ordre;
}
public int getEcheance() {
	return echeance;
}
public void setEcheance(int echeance) {
	this.echeance = echeance;
}
public Utilisateur getResponsable() {
	return responsable;
}
public void setResponsable(Utilisateur responsable) {
	this.responsable = responsable;
}

int echeance;
@ManyToOne
private Utilisateur responsable;
public void setId(Long id) {
	this.id = id;
}
@ManyToOne
private Modele modele;
@ManyToOne
private Activite Activite;
public Activite getActivite() {
	return Activite;
}
public void setActivite(Activite Activite) {
	this.Activite = Activite;
}
public Modele getModele() {
	return modele;
}
public void setModele(Modele modele) {
	this.modele = modele;
}

@ManyToOne
private Phase phase;

public Phase getPhase() {
	return phase;
}
public void setPhase(Phase phase) {
	this.phase = phase;
}
}
