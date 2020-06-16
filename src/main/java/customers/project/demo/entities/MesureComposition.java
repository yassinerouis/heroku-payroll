package customers.project.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class MesureComposition implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long identifiant;
	private int annee;
	private String libelle;
	public long getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(long identifiant) {
		this.identifiant = identifiant;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@ManyToOne
	private Modele modele;
	public MesureComposition() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Double valeur;
	public Modele getModele() {
		return modele;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public void setModele(Modele modele) {
		this.modele = modele;
	}
	public Double getValeur() {
		return valeur;
	}
	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}
}
