package customers.project.demo.entities;

import java.util.Date;

public class InfosActivite {
private long id;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
private Activite activite;
public Activite getActivite() {
	return activite;
}
public void setActivite(Activite activite) {
	this.activite = activite;
}
private String espacetravail;
private String date_echeance;
private long statut;
private String libelle_statut;
private long ordre;
private String matricule;
private long echeance;

public long getOrdre() {
	return ordre;
}
public void setOrdre(long ordre) {
	this.ordre = ordre;
}
public String getMatricule() {
	return matricule;
}
public void setMatricule(String matricule) {
	this.matricule = matricule;
}
public long getEcheance() {
	return echeance;
}
public void setEcheance(long echeance) {
	this.echeance = echeance;
}
public String getLibelle_statut() {
	return libelle_statut;
}
public void setLibelle_statut(String libelle_statut) {
	this.libelle_statut = libelle_statut;
}
private String responsable;
private String image_responsable;
private String color_statut;

public InfosActivite() {
	super();
	// TODO Auto-generated constructor stub
}

public InfosActivite(String libelle, String espacetravail, String date_echeance, long statut, String responsable,
		String image_responsable, String color_statut) {
	super();
	this.espacetravail = espacetravail;
	this.date_echeance = date_echeance;
	this.responsable = responsable;
	this.statut=statut;
	this.image_responsable = image_responsable;
	this.color_statut = color_statut;
}
public String getEspacetravail() {
	return espacetravail;
}
public void setEspacetravail(String espacetravail) {
	this.espacetravail = espacetravail;
}
public String getDate_echeance() {
	return date_echeance;
}
public void setDate_echeance(String date_echeance) {
	this.date_echeance = date_echeance;
}

public long getStatut() {
	return statut;
}
public void setStatut(long statut) {
	this.statut = statut;
}
public String getResponsable() {
	return responsable;
}
public void setResponsable(String responsable) {
	this.responsable = responsable;
}
public String getImage_responsable() {
	return image_responsable;
}
public void setImage_responsable(String image_responsable) {
	this.image_responsable = image_responsable;
}
public String getColor_statut() {
	return color_statut;
}
public void setColor_statut(String color_statut) {
	this.color_statut = color_statut;
}

}
