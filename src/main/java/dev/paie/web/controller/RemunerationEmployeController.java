package dev.paie.web.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.GradeServiceJdbcTemplate;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@PersistenceContext EntityManager em;
	
	@Autowired
	GradeServiceJdbcTemplate gradeService;
	
	
	@Autowired
	private EntrepriseRepository entService;
	
	@Autowired 
	ProfilRemunerationRepository profilService;
	
	@Autowired
	GradeRepository gradeRepo;
	
	@Autowired
	RemunerationEmployeRepository reRepo;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView displayAllEmploye(){
		ModelAndView mav = new ModelAndView();
		List<RemunerationEmploye> listEmployes = reRepo.findAll();
		mav.addObject("listEmployes", listEmployes);
		mav.setViewName("employes/listEmploye");
		
		return mav;
	}
	
	
	
	@Secured("ROLE_ADMINISTRATEUR")
	@RequestMapping(method = RequestMethod.GET, path="creer")
	public ModelAndView displayInfosCreationEmploye(){
		ModelAndView mav = new ModelAndView();
		
		List<Grade>listGrades = gradeService.lister();
		List<Entreprise> listEntreprises = entService.findAll();
		List<ProfilRemuneration> listProfils = profilService.findAll();
		
		mav.addObject("listGrades", listGrades);
		mav.addObject("listEntreprises", listEntreprises);
		mav.addObject("listProfils", listProfils);
		
		mav.setViewName("employes/creerEmploye");
		return mav;
	}
	
	@Transactional
	@Secured("ROLE_ADMINISTRATEUR")
	@RequestMapping(method = RequestMethod.POST, path="creer")
	public ModelAndView createEmploye(
			 @RequestParam("matricule")String matricule
			,@RequestParam("entreprise")int entreprise
			,@RequestParam("profil")int profil
			, @RequestParam("grade")int grade
			){
		
		ModelAndView mav = displayInfosCreationEmploye();
		
		Entreprise entreprise_ = entService.findOne(entreprise);
		ProfilRemuneration profil_ = profilService.findOne(profil);
		Grade grade_ = gradeRepo.findOne(grade);
		
		RemunerationEmploye renumEmploye = new RemunerationEmploye(matricule, entreprise_, profil_, grade_);
	
		try{
			em.persist(renumEmploye);
			mav.addObject("message", "création OK !");
			
		}catch(TransactionException e){
			mav.addObject("message", "création failed !");
			e.getMessage();
			e.getStackTrace();
		}
		
		return mav;
		
	}
	
}
