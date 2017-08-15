package dev.paie.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.RemunerationEmploye;

public interface RemunerationEmployeRepository extends JpaRepository<RemunerationEmploye, Serializable>{

}
