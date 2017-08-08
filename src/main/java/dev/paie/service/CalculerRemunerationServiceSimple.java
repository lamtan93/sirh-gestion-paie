package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService{
	
	
	private ResultatCalculRemuneration resCalculRenum;
	
	@Autowired
	PaieUtils paieUtils;
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		
		
		
		BigDecimal salaireBase =  bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());
		
			
		BigDecimal totalRetenueSalariale = null ;
		for (Cotisation taux : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()) {
			totalRetenueSalariale = totalRetenueSalariale.add(taux.getTauxSalarial().multiply(salaireBrut));
		}
				
		BigDecimal totalCotisationsPatronales = null;
		
		for (Cotisation taux : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables()) {
			totalCotisationsPatronales = totalCotisationsPatronales.add(taux.getTauxPatronal().multiply(salaireBrut));
			
		}
		
		BigDecimal netImposable = salaireBrut.subtract(totalRetenueSalariale);
		
		
		
		BigDecimal somme = null;
		for (Cotisation taux : bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables()) {
			somme = somme.add(taux.getTauxSalarial().multiply(salaireBrut));
			
		}
		
		BigDecimal netAPayer = netImposable.subtract(somme);
		
		paieUtils.formaterBigDecimal(salaireBase);
		paieUtils.formaterBigDecimal(salaireBrut);
//		paieUtils.formaterBigDecimal();
//		paieUtils.formaterBigDecimal();
//		paieUtils.formaterBigDecimal();
//		paieUtils.formaterBigDecimal();
		
		
		resCalculRenum  = new ResultatCalculRemuneration(String.valueOf(salaireBase), String.valueOf(salaireBrut), String.valueOf(totalRetenueSalariale), String.valueOf(totalCotisationsPatronales), String.valueOf(netImposable), String.valueOf(netAPayer));
		
		return resCalculRenum;
	}
}
