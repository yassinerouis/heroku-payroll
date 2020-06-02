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
	int year;
	int month;
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
	@Temporal(TemporalType.DATE)
private Date date_suppression;
@ManyToOne(fetch = FetchType.LAZY)
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

public Date getDate_suppression() {
	return date_suppression;
}
public void setDate_suppression(Date date_suppression) {
	this.date_suppression = date_suppression;
}
}
