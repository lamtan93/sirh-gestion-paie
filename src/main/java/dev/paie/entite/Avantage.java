package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avantage {

	@Id
	private Integer id;
	private String code;
	private String nom;
	private BigDecimal montant;

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private ProfilRemuneration profilRemuneration;
	
	public String getCode() {
		return code;
	}

	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}

	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Avantage(){
		
	}
	
	public Avantage(Integer id, String code, String nom, BigDecimal montant) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.montant = montant;
	}
	
	
	
}
