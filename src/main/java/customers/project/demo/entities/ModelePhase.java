package customers.project.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ModelePhase implements Serializable{
private static final long serialVersionUID = 1L;
@javax.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@ManyToOne(cascade = javax.persistence.CascadeType.PERSIST,fetch = FetchType.LAZY)
private Modele modele;
@ManyToOne(cascade = javax.persistence.CascadeType.PERSIST,fetch = FetchType.LAZY)
private Phase phase;

public Phase getPhase() {
	return phase;
}
public void setPhase(Phase phase) {
	this.phase = phase;
}
public Modele getModele() {
	return modele;
}
public void setModele(Modele modele) {
	this.modele = modele;
}
}
