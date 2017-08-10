package dev.paie.entite;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Periode {

	@Id
	private Integer id;
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date dateDebut;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP) 
	private Date dateFin;
	
	@OneToMany(mappedBy= "periode", cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<BulletinSalaire> bulletinSalaires;
	
	
	public Periode(){
		bulletinSalaires = new ArrayList<>();
	}
	
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	

}
