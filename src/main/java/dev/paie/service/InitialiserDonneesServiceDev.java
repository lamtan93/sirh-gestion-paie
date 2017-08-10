package dev.paie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService{

	private ClassPathXmlApplicationContext context;
	private Entreprise entreprise;
	private Grade grade;
	private ProfilRemuneration profilRemuneration;
	
	//@Autowired ApplicationContext context; //2eme option

	@Autowired
	GradeServiceJdbcTemplate gradeService;
	
	Map<String, Grade> mapGrades;
	
	public  InitialiserDonneesServiceDev() {
		context = new ClassPathXmlApplicationContext("entreprises.xml","grades.xml", "profils-remuneration.xml");
		

		mapGrades = context.getBeansOfType(Grade.class);
		
		
		context.close();
	}

	
	@Override
	public void initialiser() {
		
		List<Grade> listGrade = new ArrayList<>();
		
		for (String gradeKey : mapGrades.keySet()) {
			
			listGrade.add(mapGrades.get(gradeKey));			
		}
		
		for (Grade grade : listGrade) {
			gradeService.sauvegarder(grade);
		}
		
		
		
	}

	
}
