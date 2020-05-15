package customers.project.demo.entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

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
@Convert(converter = StringListConverter.class)
private List<String> roles;
@Convert(converter = StringListConverter.class)
private List<String> pays;
private String valeur_lien;
private String menu;
private String logo;
public List<String> getRoles() {
	return roles;
}
public void setRoles(List<String> roles) {
	this.roles = roles;
}
public List<String> getPays() {
	return pays;
}
public void setPays(List<String> pays) {
	this.pays = pays;
}
public String getValeur_lien() {
	return valeur_lien;
}
public void setValeur_lien(String valeur_lien) {
	this.valeur_lien = valeur_lien;
}
public String getLogo() {
	return logo;
}
public void setLogo(String logo) {
	this.logo = logo;
}
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
