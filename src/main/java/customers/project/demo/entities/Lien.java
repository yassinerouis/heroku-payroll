package customers.project.demo.entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Lien implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String libelle;
private String description;
private int ordre_affichage;
private boolean sous_lien;
private String valeur_lien;
private String menu;
public String getMenu() {
	return menu;
}
public void setMenu(String menu) {
	this.menu = menu;
}
public boolean getSous_lien() {
	return sous_lien;
}
public void setSous_lien(boolean sous_lien) {
	this.sous_lien = sous_lien;
}
public String getLien() {
	return valeur_lien;
}
public void setLien(String lien) {
	this.valeur_lien = lien;
}
public int getId() {
	return id;
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
public void setId(int id) {
	this.id = id;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
}
