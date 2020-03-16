package customers.project.demo.entities;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Population implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
String code_population;
String libelle;


@ManyToOne(fetch = FetchType.LAZY)
private TypePopulation typepopulation;

public TypePopulation getTypepopulation() {
	return typepopulation;
}
public void setTypepopulation(TypePopulation typepopulation) {
	this.typepopulation = typepopulation;
}

public String getCode_population() {
	return code_population;
}
public void setCode_population(String code_population) {
	this.code_population = code_population;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}

}
