package customers.project.demo.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Suivi implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	private int year;
	private int month;
	private boolean clotured;
	public boolean isClotured() {
		return clotured;
	}
	public void setClotured(boolean clotured) {
		this.clotured = clotured;
	}
	@ManyToOne
	private ModeleSuivi modele;
	@ManyToOne
	private Population population;
	public ModeleSuivi getModele() {
		return modele;
	}
	public void setModele(ModeleSuivi modele) {
		this.modele = modele;
	}
	public Population getPopulation() {
		return population;
	}
	public void setPopulation(Population population) {
		this.population = population;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
}
