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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class SousLien implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	private int ordre_affichage;
	@Convert(converter = StringListConverter.class)
	private List<String> roles;	
	private String valeur_lien;
	public String getValeur_lien() {
		return valeur_lien;
	}
	public void setValeur_lien(String valeur_lien) {
		this.valeur_lien = valeur_lien;
	}
	@OneToOne
	private Lien lien;
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Lien getLien() {
		return lien;
	}

	public void setLien(Lien lien) {
		this.lien = lien;
	}
	
	public int getOrdre_affichage() {
		return ordre_affichage;
	}

	public void setOrdre_affichage(int ordre_affichage) {
		this.ordre_affichage = ordre_affichage;
	}

	public int getId() {
		return id;
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
