package dev.paie.entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class RemunerationEmploye implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String matricule;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Entreprise entreprise;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ProfilRemuneration profilRemuneration;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Grade grade;

	@OneToMany(mappedBy = "remunerationEmploye", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<BulletinSalaire> bulletinSalaires;

	public RemunerationEmploye() {
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

	public RemunerationEmploye(String matricule, Entreprise entreprise, ProfilRemuneration profilRemuneration,
			Grade grade) {
		super();
		this.matricule = matricule;
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
	}

}
