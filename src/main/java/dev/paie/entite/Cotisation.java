package dev.paie.entite;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cotisation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String libelle;
	private BigDecimal tauxSalarial;
	private BigDecimal tauxPatronal;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProfilRemuneration> profilRemuneration_CotisationsNonImposable;

	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProfilRemuneration>profilRemuneration_CotisationsImposable;
	

	public Cotisation(){
		profilRemuneration_CotisationsNonImposable = new ArrayList<>();
		profilRemuneration_CotisationsImposable = new ArrayList<>();
	}

	public List<ProfilRemuneration> getProfilRemuneration_CotisationNonImposable() {
		return profilRemuneration_CotisationsNonImposable;
	}

	public void setProfilRemuneration_CotisationNonImposable(
			List<ProfilRemuneration> profilRemuneration_CotisationNonImposable) {
		this.profilRemuneration_CotisationsNonImposable = profilRemuneration_CotisationNonImposable;
	}

	public List<ProfilRemuneration> getProfilRemuneration_CotisationImposable() {
		return profilRemuneration_CotisationsImposable;
	}

	public void setProfilRemuneration_CotisationImposable(List<ProfilRemuneration> profilRemuneration_CotisationImposable) {
		this.profilRemuneration_CotisationsImposable = profilRemuneration_CotisationImposable;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}

	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}

	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}

	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Cotisation(Integer id, String code, String libelle, BigDecimal tauxSalarial, BigDecimal tauxPatronal) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.tauxSalarial = tauxSalarial;
		this.tauxPatronal = tauxPatronal;
	}

}
