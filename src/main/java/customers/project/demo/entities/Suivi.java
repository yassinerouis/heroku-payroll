package customers.project.demo.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
@Entity
public class Suivi implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id

private String code;
	@Temporal(TemporalType.DATE)
	private Date date_creation;
	@Temporal(TemporalType.DATE)
private Date date_fin;
@ManyToOne(fetch = FetchType.LAZY)
private Modele modele;
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public Date getDate_creation() {
	return date_creation;
}
public void setDate_creation(Date date_creation) {
	this.date_creation = date_creation;
}
public Date getDate_fin() {
	return date_fin;
}
public void setDate_fin(Date date_fin) {
	this.date_fin = date_fin;
}
}
