package customers.project.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Devise implements Serializable{
private static final long serialVersionUID = 1L;
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
int identifiant;
String libelle;
String symbol;
float valeur_euro;
public int getIdentifiant() {
	return identifiant;
}
public Devise() {
	super();
	// TODO Auto-generated constructor stub
}
public void setIdentifiant(int identifiant) {
	this.identifiant = identifiant;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public String getSymbol() {
	return symbol;
}
public void setSymbol(String symbol) {
	this.symbol = symbol;
}
public float getValeur_euro() {
	return valeur_euro;
}
public void setValeur_euro(float valeur_euro) {
	this.valeur_euro = valeur_euro;
}
}
