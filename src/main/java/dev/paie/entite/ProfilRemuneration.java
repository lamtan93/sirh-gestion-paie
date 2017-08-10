package dev.paie.entite;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


public class ProfilRemuneration {

	private Integer id;
	private String code;

	@OneToMany(mappedBy="profilRemuneration", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Cotisation> cotisationsNonImposables;
	
	@OneToMany(mappedBy="profilRemuneration", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Cotisation> cotisationsImposables;
	
	@OneToMany(mappedBy="profilRemuneration", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Avantage> avantages;

	
	
	@OneToMany(mappedBy="profilRemuneration" ,cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<RemunerationEmploye>remunerationEmployes;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
