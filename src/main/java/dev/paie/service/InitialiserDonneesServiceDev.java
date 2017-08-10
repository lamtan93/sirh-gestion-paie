package dev.paie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.CotisationRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService{

	private ClassPathXmlApplicationContext context;
	
	private Entreprise entreprise;
	private Grade grade;
	private ProfilRemuneration profilRemuneration;
	
	//@Autowired ApplicationContext context; //2eme option

	@Autowired
	GradeServiceJdbcTemplate gradeService;
	
	
	@Autowired
	private EntrepriseRepository entService;
	
	@Autowired 
	ProfilRemunerationRepository profilService;
	
	@Autowired
	CotisationRepository cotisRepository;
	
	Map<String, Grade> mapGrades;
	Map<String, Entreprise> mapEntreprises;
	Map<String, ProfilRemuneration> mapProfilRemunerations;
	
	
	
	
	List<Cotisation> cotis = new ArrayList<>();
	
	public  InitialiserDonneesServiceDev() {
		context = new ClassPathXmlApplicationContext("entreprises.xml","grades.xml", "profils-remuneration.xml");
		
		mapGrades = context.getBeansOfType(Grade.class);
		mapEntreprises = context.getBeansOfType(Entreprise.class);
		mapProfilRemunerations = context.getBeansOfType(ProfilRemuneration.class);
		
		context.close();
	}

	
	@Override
	public void initialiser() {
		
		for (String gradeKey : mapGrades.keySet()) {
			gradeService.sauvegarder(mapGrades.get(gradeKey));
		}

		for (String entrKey : mapEntreprises.keySet()) {
			entService.save(mapEntreprises.get(entrKey));
		}
		
		
	}

	
}
