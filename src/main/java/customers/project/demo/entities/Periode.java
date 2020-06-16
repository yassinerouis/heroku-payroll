package customers.project.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Periode implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long identifiant;
	private int annee;
	private int mois;
public long getIdentifiant() {
	return identifiant;
}
public void setIdentifiant(long identifiant) {
	this.identifiant = identifiant;
}
public int getAnnee() {
	return annee;
}
public void setAnnee(int annee) {
	this.annee = annee;
}
public int getMois() {
	return mois;
}
public void setMois(int mois) {
	this.mois = mois;
}
public Periode() {
	super();
	// TODO Auto-generated constructor stub
}
}
