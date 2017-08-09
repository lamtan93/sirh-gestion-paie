package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Service
@Transactional
public class CotisationServiceJpa implements CotisationService{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void sauvegarder(Cotisation nouvelleCotisation) {
	em.persist(nouvelleCotisation);
	}

	@Override
	public void mettreAJour(Cotisation cotisation) {
		String jpql = "UPDATE Cotisation c SET c.libelle=:libelle WHERE c.id=:id";
		
		Query query = em.createQuery(jpql);
		query.setParameter("libelle", cotisation.getLibelle());
		query.setParameter("id", cotisation.getId());
		
		
		em.merge(cotisation);
	}

	@Override
	public List<Cotisation> lister() {
		
		String jpql = "SELECT c FROM Cotisation c";
		Query query = em.createQuery(jpql);
		
		List<Cotisation> listCotis = query.getResultList();
		
		return listCotis;
	}

}
