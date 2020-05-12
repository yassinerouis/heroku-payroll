package customers.project.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class TypePopulation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identifiant;
	private String libelle;
	
	
	public TypePopulation(int identifiant, String libelle, Set<Population> population, Set<PopulationModele> modele) {
		super();
		this.identifiant = identifiant;
		this.libelle = libelle;
		
		
	}
	
	
	
	
	public TypePopulation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdentifiant() {
		return identifiant;
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
}
