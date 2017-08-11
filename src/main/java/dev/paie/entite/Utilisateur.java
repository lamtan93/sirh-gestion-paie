package dev.paie.entite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String nomUtilisateur;
	private String motDePasse;
	private Boolean estActif;
	
	
	public enum ROLES {
		ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR
	}
	@Enumerated(EnumType.STRING)
	private ROLES role;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Boolean getEstActif() {
		return estActif;
	}
	public void setEstActif(Boolean estActif) {
		this.estActif = estActif;
	}
	public ROLES getRole() {
		return role;
	}
	public void setRole(ROLES role) {
		this.role = role;
	}
	public Utilisateur( String nomUtilisateur, String motDePasse, Boolean estActif, ROLES role) {
		super();
		
		this.nomUtilisateur = nomUtilisateur;
		this.motDePasse = motDePasse;
		this.estActif = estActif;
		this.role = role;
	}


}
