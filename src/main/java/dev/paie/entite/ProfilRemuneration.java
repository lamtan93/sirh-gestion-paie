package dev.paie.entite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ProfilRemuneration {

	@Id
	private Integer id;
	private String code;

	@ManyToMany(mappedBy="profilRemunerations", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Cotisation> cotisationsNonImposables;
	
	@ManyToMany(mappedBy="profilRemunerations", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Cotisation> cotisationsImposables;
	
	@ManyToMany(mappedBy="profilRemunerations", cascade=CascadeType.ALL)
	private List<Avantage> avantages;

	
	
	@OneToMany(mappedBy="profilRemuneration" ,cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<RemunerationEmploye>remunerationEmployes;
	
	
	
	public ProfilRemuneration (){
		cotisationsImposables = new ArrayList<>();
		cotisationsNonImposables = new ArrayList<>();
		avantages = new ArrayList<>();
	}
	
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

	public Collection<RemunerationEmploye> getRemunerationEmployes() {
		return remunerationEmployes;
	}

	public void setRemunerationEmployes(Collection<RemunerationEmploye> remunerationEmployes) {
		this.remunerationEmployes = remunerationEmployes;
	}

}
