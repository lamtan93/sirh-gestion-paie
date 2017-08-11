package dev.paie.entite;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Periode {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	private LocalDate dateDebut;
	
	private LocalDate dateFin;
	
	@OneToMany(mappedBy= "periode", cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<BulletinSalaire> bulletinSalaires;
	
	
	public Periode(){
		bulletinSalaires = new ArrayList<>();
	}
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Periode(LocalDate dateDebut, LocalDate dateFin){
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	

}
