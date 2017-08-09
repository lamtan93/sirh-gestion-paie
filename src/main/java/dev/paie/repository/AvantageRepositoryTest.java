package dev.paie.repository;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

@ContextConfiguration(classes={ServicesConfig.class})
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired 
	private AvantageRepository avantageRepository;
	
	
	@Test
	public void test_insert() {
	// TODO sauvegarder un nouvel avantage
	// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
	
		
		Avantage avt1 = new Avantage(1, "avt01", "Avantage01", new BigDecimal(15.15));
		Avantage avt2 = new Avantage(2, "avt02", "Avantage02", new BigDecimal(45.15));
		Avantage avt3 = new Avantage(3, "avt03", "Avantage03", new BigDecimal(47.15));
		
		avantageRepository.save(avt1);
		avantageRepository.save(avt2);
		avantageRepository.save(avt3);
		
		List<Avantage> listAll = avantageRepository.findAll();
		
		int count = 0;
		for (Avantage avantage : listAll) {
			count++;
		}
		
		assertTrue(count==3);
	}
	
	
//	@Test
//	public void test_update(){
//		// TODO modifier un avantage
//		// TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
//		
//		List<Avantage> avantage = avantageRepository.findById(1);
//		String codeToCHange = "helloCode";
//		for (Avantage a : avantage) {
//			 avantageRepository.updateAvantageById(codeToCHange, a.getId());
//		}
//		
//		List<Avantage> avtAfterChanged = avantageRepository.findById(1);
//		
//		String codeAfterChange = "";
//		for (Avantage avt : avtAfterChanged) {
//			codeAfterChange = avt.getCode();
//			
//		}
//		
//		
//		assertTrue(codeAfterChange.equalsIgnoreCase(codeToCHange));
//	}
	
	
}
