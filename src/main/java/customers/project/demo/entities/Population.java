package customers.project.demo.entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Population implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identifiant;
	String libelle;


public Population() {
		super();
		// TODO Auto-generated constructor stub
	}
@ManyToOne(cascade = javax.persistence.CascadeType.PERSIST)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
private TypePopulation typepopulation;

public Population(int identifiant, String libelle, TypePopulation typepopulation) {
	super();
	this.identifiant = identifiant;
	this.libelle = libelle;
	this.typepopulation = typepopulation;
}
public TypePopulation getTypepopulation() {
	return typepopulation;
}
public void setTypepopulation(TypePopulation typepopulation) {
	this.typepopulation = typepopulation;
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
