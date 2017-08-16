package dev.paie.web.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.BulletinService;

@Controller
@RequestMapping("/bulletins")
public class BulletinController {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	BulletinRepository bulletinRepo;
	
	@Autowired
	PeriodeRepository periodeRepo;
	
	
	@Autowired
	RemunerationEmployeRepository reRepo;
	
	@Autowired
	BulletinService bulletinService;
	
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView displayListBulletins(){
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("listBulletins",bulletinService.lister());
		mav.setViewName("bulletins/listBulletins");
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET,path="creer")
	public ModelAndView displayInfosCreationBulletin(){
		
		ModelAndView mav = new ModelAndView();
		
		List<Periode> listPeriodes = periodeRepo.findAll();
		List<RemunerationEmploye> listRemunerationEmploye = reRepo.findAll();
		
		mav.addObject("listPeriodes",listPeriodes);
		mav.addObject("listRemunerationEmployes",listRemunerationEmploye);
		
		mav.setViewName("bulletins/creerBulletin");
		
		return mav;
	}
	@Transactional
	@RequestMapping(method=RequestMethod.POST, path="creer")
	public ModelAndView createBulletin(
			@RequestParam("periode")int idPeriode
		   ,@RequestParam("remunerationEmploye")int idRemunerationEmploye
		   ,@RequestParam("primeExceptionnelle")String primeExceptionnelle
			){
		
		ModelAndView mav = displayInfosCreationBulletin();
		
		String primeExceptionnelleAfterFilter = primeExceptionnelle.replaceAll(",", "");
		
		BulletinSalaire bs = new BulletinSalaire();
		bs.setPeriode(periodeRepo.findOne(idPeriode));
		bs.setRemunerationEmploye(reRepo.findOne(idRemunerationEmploye));
		bs.setPrimeExceptionnelle(new BigDecimal(primeExceptionnelleAfterFilter));
		
		try {
			em.persist(bs);
			mav.addObject("message","création OK !");
		} catch (PersistenceException e) {
			mav.addObject("message","création failed !");
			e.getMessage();
			e.getStackTrace();
		}
		
		return mav;
	}
	
	
	//====================Display a bulletin==========================
	
	@RequestMapping(method=RequestMethod.GET, path="visualiserBulletin")
	public ModelAndView displayBulletin(@RequestParam("bulletinId")int bulletinId){
		ModelAndView mav = new ModelAndView();
		
	
		BulletinSalaire bull = bulletinRepo.findOne(bulletinId);
		
		
		mav.addObject("bulletinSalaire", bull);
		
		mav.setViewName("bulletins/visualiserBulletin");
		return mav;
	}
	
}
