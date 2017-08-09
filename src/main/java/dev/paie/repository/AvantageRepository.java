package dev.paie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.paie.entite.Avantage;

public interface AvantageRepository extends JpaRepository<Avantage, Integer>{

	Avantage save(Avantage avantage);
	List<Avantage>findByCode(String code);
	
	List<Avantage>findById(int id);
	
	@Query("UPDATE Avantage SET code=:code WHERE id=:id")
	void updateAvantageById(@Param("code") String code, @Param("id")int id);
}
