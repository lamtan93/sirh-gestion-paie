package dev.paie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.Utilisateur;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.UtilisateurRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService{
	
	//@Autowired ApplicationContext context; //2eme option

	@Autowired
	PasswordEncoder encodePws;
	
	
	@Autowired
	GradeServiceJdbcTemplate gradeService;
	
	
	@Autowired
	private EntrepriseRepository entService;
	
	@Autowired 
	ProfilRemunerationRepository profilService;
	
	@Autowired
	CotisationRepository cotisRepository;
	
	@Autowired
	PeriodeRepository periodeService;
	
	@Autowired
	UtilisateurRepository userRepos;
	
	
	Map<String, Grade> mapGrades;
	Map<String, Entreprise> mapEntreprises;
	Map<String, ProfilRemuneration> mapProfilRemunerations;
	Map<String, Cotisation> mapCotisations;
	
	@PersistenceContext EntityManager em;
	
	
	
	List<Cotisation> cotis = new ArrayList<>();
	
	public  InitialiserDonneesServiceDev() {
		
	}

	
	@Override
	@Transactional
	public void initialiser() {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("entreprises.xml","grades.xml", "profils-remuneration.xml", "cotisations-non-imposables.xml", "cotisations-imposables.xml" );
		
		mapGrades = context.getBeansOfType(Grade.class);
		mapEntreprises = context.getBeansOfType(Entreprise.class);
		mapProfilRemunerations = context.getBeansOfType(ProfilRemuneration.class);
		mapCotisations = context.getBeansOfType(Cotisation.class);
		//mapCotisationsImposables = context.getBeansOfType(Cotisation.class);
		
		
		
		for (String gradeKey : mapGrades.keySet()) {
			gradeService.sauvegarder(mapGrades.get(gradeKey));
		}
		
		mapEntreprises.forEach((k, v) -> {
			entService.save(v);
		});
		
		
		mapCotisations.forEach((k, v) -> {
			em.persist(v);
		});
		
		mapProfilRemunerations.forEach((k, v) -> {
			em.persist(v);
		});
		
		
		List<Periode> pers = new ArrayList<>();
		
		 pers.add(new Periode(LocalDate.of(2017, 1, 1), LocalDate.of(2017, 1, 31)));
		
		 pers.add(new Periode(LocalDate.of(2017, 2, 1), LocalDate.of(2017,
		 2, 28)));
		 pers.add(new Periode(LocalDate.of(2017, 3, 1), LocalDate.of(2017,
		 3, 31)));
		 pers.add(new Periode(LocalDate.of(2017, 4, 1), LocalDate.of(2017,
		 4, 30)));
		 pers.add(new Periode(LocalDate.of(2017, 5, 1), LocalDate.of(2017,
		 5, 31)));
		 pers.add(new Periode(LocalDate.of(2017, 6, 1), LocalDate.of(2017,
		 6, 30)));
		 pers.add(new Periode(LocalDate.of(2017, 7, 1), LocalDate.of(2017,
		 7, 31)));
		 pers.add(new Periode(LocalDate.of(2017, 8, 1), LocalDate.of(2017,
		 8, 31)));
		 pers.add(new Periode(LocalDate.of(2017, 9, 1), LocalDate.of(2017,
		 9, 30)));
		 pers.add(new Periode(LocalDate.of(2017, 10, 1), LocalDate.of(2017,
		 10, 31)));
		 pers.add(new Periode(LocalDate.of(2017, 11, 1), LocalDate.of(2017,
		 11, 30)));
		 pers.add(new Periode(LocalDate.of(2017, 12, 1), LocalDate.of(2017,
		 12, 31)));
		
		pers.stream().forEach(p -> periodeService.save(p));
		
		
		List<Utilisateur> listUsers = Arrays.asList(
		
		new Utilisateur("admin", encodePws.encode("admin") , true, Utilisateur.ROLES.ROLE_ADMINISTRATEUR),
		new Utilisateur("LAM", encodePws.encode("lam123"), true, Utilisateur.ROLES.ROLE_UTILISATEUR),
		new Utilisateur("TOTO", encodePws.encode("toto123"), false, Utilisateur.ROLES.ROLE_UTILISATEUR),
		new Utilisateur("TITI", encodePws.encode("titi123"), true, Utilisateur.ROLES.ROLE_UTILISATEUR)
		);
		
		listUsers.stream().forEach(u -> userRepos.save(u));
		context.close();
	}

		
		
		
			
		
		
	
}
