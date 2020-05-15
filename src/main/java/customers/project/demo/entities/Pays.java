package customers.project.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Pays {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	private String reglementation;
	private String libelle;
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	private String logo;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getReglementation() {
		return reglementation;
	}
	public void setReglementation(String reglementation) {
		this.reglementation = reglementation;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
