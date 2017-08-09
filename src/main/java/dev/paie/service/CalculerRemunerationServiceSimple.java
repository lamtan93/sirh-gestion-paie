package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	private PaieUtils paieUtils;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		ResultatCalculRemuneration result = new ResultatCalculRemuneration();

		Grade grade = bulletin.getRemunerationEmploye().getGrade();
		BigDecimal salaireBase = grade.getNbHeuresBase().multiply(grade.getTauxBase());
		String salaireBaseString = paieUtils.formaterBigDecimal(salaireBase);
		result.setSalaireDeBase(salaireBaseString);
		salaireBase = new BigDecimal(salaireBaseString);

		BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());
		String salaireBrutString = paieUtils.formaterBigDecimal(salaireBrut);
		result.setSalaireBrut(salaireBrutString);
		salaireBrut = new BigDecimal(salaireBrutString);

		ProfilRemuneration profil = bulletin.getRemunerationEmploye().getProfilRemuneration();

		BigDecimal totalRetenueSalariale = profil.getCotisationsNonImposables().stream()
				.filter(t -> t.getTauxSalarial() != null).map(t -> t.getTauxSalarial())
				.reduce(BigDecimal.ZERO, BigDecimal::add).multiply(salaireBrut);

		String totalRetenueSalarialeString = paieUtils.formaterBigDecimal(totalRetenueSalariale);
		totalRetenueSalariale = new BigDecimal(totalRetenueSalarialeString);
		result.setTotalRetenueSalarial(totalRetenueSalarialeString);

		BigDecimal totalCotisationsPatronales = profil.getCotisationsNonImposables().stream()
				.filter(t -> t.getTauxPatronal() != null).map(t -> t.getTauxPatronal())
				.reduce(BigDecimal.ZERO, BigDecimal::add).multiply(salaireBrut);

		String totalCotisationsPatronalesString = paieUtils.formaterBigDecimal(totalCotisationsPatronales);
		totalCotisationsPatronales = new BigDecimal(totalCotisationsPatronalesString);
		result.setTotalCotisationsPatronales(totalCotisationsPatronalesString);

		BigDecimal netImposable = salaireBrut.subtract(totalRetenueSalariale);
		String netImposableString = paieUtils.formaterBigDecimal(netImposable);
		netImposable = new BigDecimal(netImposableString);
		result.setNetImposable(netImposableString);

		BigDecimal netAPayer = netImposable
				.subtract(profil.getCotisationsImposables().stream().filter(t -> t.getTauxSalarial() != null)
						.map(t -> t.getTauxSalarial()).reduce(BigDecimal.ZERO, BigDecimal::add).multiply(salaireBrut));

		String netAPayerString = paieUtils.formaterBigDecimal(netAPayer);
		netAPayer = new BigDecimal(netAPayerString);
		result.setNetAPayer(netAPayerString);

		return result;
	}
}
