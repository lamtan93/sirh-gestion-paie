package dev.paie.entite;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Avantage {

	@Id
	private Integer id;
	private String code;
	private String nom;
	private BigDecimal montant;

	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<ProfilRemuneration> profilRemunerations;
	
	public String getCode() {
		return code;
	}

	
	

	public List<ProfilRemuneration> getProfilRemunerations() {
		return profilRemunerations;
	}




	public void setProfilRemunerations(List<ProfilRemuneration> profilRemunerations) {
		this.profilRemunerations = profilRemunerations;
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
