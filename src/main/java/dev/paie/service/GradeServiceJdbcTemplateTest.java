package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

@ContextConfiguration(classes={DataSourceMySQLConfig.class,ServicesConfig.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;
	
	
// TODO sauvegarder un nouveau grade
// TODO vérifier qu'il est possible de récupérer le nouveau grade via la méthode lister
		
	@Test
	public void test_insert() {
	
	
		Grade grade1 = new Grade(1, "grade_01", new BigDecimal(12.5), new BigDecimal(78.5));
		Grade grade2 = new Grade(2, "grade_02", new BigDecimal(26.5), new BigDecimal(15.5));
		Grade grade3 = new Grade(3, "grade_03", new BigDecimal(14.5), new BigDecimal(46.5));
		
//		gradeService.sauvegarder(grade1); //id - PK
//		gradeService.sauvegarder(grade2);
//		gradeService.sauvegarder(grade3);
		
		List<Grade> listGrade = gradeService.lister();
		int count=0;
		
		for (Grade g : listGrade) {
			count++;
		}
		
		assertTrue(count==3);
	}
	

// TODO modifier un grade
// TODO vérifier que les modifications sont bien prises en compte via la méthode lister
		
	@Test
	public void test_update(){
		
		Grade newGrade = new Grade(1, "grade_modified_04", new BigDecimal(12.78), new BigDecimal(45.67));
		gradeService.mettreAJour(newGrade);
		
		String codeGradeModified = "";
		
		List<Grade> listGrade = gradeService.lister();
		
		for (Grade g : listGrade) {
			if(g.getId()==1){
				codeGradeModified = g.getCode();
			}
		}
		
		assertTrue(codeGradeModified.equalsIgnoreCase(newGrade.getCode()));
		System.out.println("code modified for Grade with id = 1 :" + codeGradeModified);
	}
	
	
	
}
