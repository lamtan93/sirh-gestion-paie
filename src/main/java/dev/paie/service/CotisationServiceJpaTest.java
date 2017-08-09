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
import dev.paie.entite.Cotisation;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

@ContextConfiguration(classes={JpaConfig.class,ServicesConfig.class, DataSourceMySQLConfig.class})
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	
	
	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder() {
		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister
		
		
		Cotisation cot1 = new Cotisation(1, "cotis_01", "Cotisation01", new BigDecimal(12.5), new BigDecimal(45.5));
		Cotisation cot2 = new Cotisation(2, "cotis_02", "Cotisation01", new BigDecimal(15.5), new BigDecimal(78.5));
		Cotisation cot3 = new Cotisation(3, "cotis_03", "Cotisation01", new BigDecimal(19.5), new BigDecimal(12.5));
		
		cotisationService.sauvegarder(cot1);
		cotisationService.sauvegarder(cot2);
		cotisationService.sauvegarder(cot3);
		
		List<Cotisation> listCotis = cotisationService.lister();
		int count = 0;
		
		for (Cotisation cotisation : listCotis) {
			count++;
		}
		
		assertTrue(count==3);
	}
	
	
	@Test
	public void test_update() {
		
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
	
		Cotisation cot1 = new Cotisation(1, "cotis_01", "Cotisation_Modified", new BigDecimal(12.5), new BigDecimal(45.5));
		
		cotisationService.mettreAJour(cot1);
		
		List<Cotisation>listCotis = cotisationService.lister();
		String cotiLibelleModified = "";
		for (Cotisation cotisation : listCotis) {
			if(cotisation.getId()==cot1.getId()){
				cotiLibelleModified = cotisation.getLibelle();
			}
		}		
		assertTrue(cot1.getLibelle().equalsIgnoreCase(cotiLibelleModified));
		
	}
	
	
	
	
	
}