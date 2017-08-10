package dev.paie.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Serializable>{

	
	
}
