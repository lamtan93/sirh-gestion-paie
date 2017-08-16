package dev.paie.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinRepository;

@Service
public class BulletinServiceImpl implements BulletinService {
	
	@Autowired
	BulletinRepository bulletins;
	
	@Autowired
	CalculerRemunerationServiceSimple calculRemunerationService;
	
	
	@Override
	public Map<BulletinSalaire, ResultatCalculRemuneration> lister() {
		
		Map<BulletinSalaire, ResultatCalculRemuneration> listeBulletins = new HashMap<>();
		
		bulletins.findAll().stream().forEach(bull -> listeBulletins.put(bull, calculRemunerationService.calculer(bull)));
		return listeBulletins;
	}

}