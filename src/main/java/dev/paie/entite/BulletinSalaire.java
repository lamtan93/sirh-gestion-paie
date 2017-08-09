package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BulletinSalaire {
	@Id
	private Integer id;
	
	@ManyToOne(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private RemunerationEmploye remunerationEmploye;
	
	@ManyToOne(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private Periode periode;
	
	
	private BigDecimal primeExceptionnelle;
	
	
	public BulletinSalaire(){};
	
	
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
