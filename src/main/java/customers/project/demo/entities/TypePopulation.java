package customers.project.demo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class TypePopulation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String type_population;
	private String libelle;
	@OneToMany(mappedBy = "typepopulation")
	@JsonIgnore
	private Set<Population> population=new HashSet<Population>();
	
	public Set<Population> getPopulation() {
		return population;
	}
	public void setPopulation(Set<Population> population) {
		this.population = population;
	}
	public Set<PopulationModele> getModele() {
		return modele;
	}
	public void setModele(Set<PopulationModele> modele) {
		this.modele = modele;
	}
	@OneToMany(mappedBy = "typepopulation")
	@JsonIgnore

	private Set<PopulationModele> modele=new HashSet<PopulationModele>();
	public TypePopulation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getType_population() {
		return type_population;
	}
	public void setType_population(String type_population) {
		this.type_population = type_population;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
