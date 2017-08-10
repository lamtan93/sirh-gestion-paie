package dev.paie.entite;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class RemunerationEmploye {
	
	private Integer id;
	private String matricule;
	
	@ManyToOne(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private Entreprise entreprise;
	
	@ManyToOne(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private ProfilRemuneration profilRemuneration;
	
	@ManyToOne(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private Grade grade;
	
	@OneToMany(mappedBy= "remunerationEmploye", cascade= CascadeType.ALL, fetch=FetchType.EAGER)
	private Collection<BulletinSalaire> bulletinSalaires;
	
	
	public RemunerationEmploye(){
		bulletinSalaires = new ArrayList<>();
	}
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	

}
