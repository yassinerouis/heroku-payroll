package customers.project.demo.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Modele implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	long code_modele;
	
	public Modele() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setModele(Modele modele) {
		this.setLibelle(modele.libelle);
		this.setReglementation(modele.reglementation);
		this.setTypepaie(modele.typepaie);
		this.setFrequence(modele.frequence);
		this.setTypepopulation(modele.typepopulation);
		this.setDate_cible(date_cible);
	}
	String libelle;
	String reglementation;
	
	int date_cible;

	public TypePaie getTypepaie() {
		return typepaie;
	}
	public void setTypepaie(TypePaie typepaie) {
		this.typepaie = typepaie;
	}
	

	@ManyToOne
	private Frequence frequence;
	@ManyToOne

	private TypePaie typepaie;
	@ManyToOne
	private TypePopulation typepopulation;
	public Frequence getFrequence() {
		return frequence;
	}
	public TypePopulation getTypepopulation() {
		return typepopulation;
	}
	public void setTypepopulation(TypePopulation typepopulation) {
		this.typepopulation = typepopulation;
	}
	public void setFrequence(Frequence frequence) {
		this.frequence = frequence;
	}
	public Set<ResponsabiliteModele> getRespomodele() {
		return respomodele;
	}
	public void setRespomodele(Set<ResponsabiliteModele> respomodele) {
		this.respomodele = respomodele;
	}
	
	
	@OneToMany(mappedBy = "modele")
	@JsonIgnore

	private Set<ResponsabiliteModele> respomodele=new HashSet<ResponsabiliteModele>();

	public long getCode_modele() {
		return code_modele;
	}
	public void setCode_modele(long code_modele) {
		this.code_modele = code_modele;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getReglementation() {
		return reglementation;
	}
	public int getDate_cible() {
		return date_cible;
	}
	public void setDate_cible(int date_cible) {
		this.date_cible = date_cible;
	}
	public void setReglementation(String reglementation) {
		this.reglementation = reglementation;
	}
	

	
}
