package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/bulletins")
public class BulletinController {

	@Autowired
	BulletinRepository bulletinRepo;
	
	@Autowired
	PeriodeRepository periodeRepo;
	
	
	@Autowired
	RemunerationEmployeRepository reRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView displayListBulletins(){
		ModelAndView mav = new ModelAndView();
		
		List<BulletinSalaire> listBulletins = bulletinRepo.findAll();
		mav.addObject("listBulletins",listBulletins);
		
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
	
	
	
}
