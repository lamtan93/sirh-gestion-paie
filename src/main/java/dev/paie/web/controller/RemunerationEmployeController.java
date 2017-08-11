package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.service.GradeServiceJdbcTemplate;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	
	@Autowired
	GradeServiceJdbcTemplate gradeService;
	
	
	@Autowired
	private EntrepriseRepository entService;
	
	@Autowired 
	ProfilRemunerationRepository profilService;
	
	
	@Secured("ROLE_ADMINISTRATEUR")
	@RequestMapping(method = RequestMethod.GET, path="creer")
	public ModelAndView creerEmploye(){
		ModelAndView mav = new ModelAndView();
		
		List<Grade>listGrades = gradeService.lister();
		List<Entreprise> listEntreprises = entService.findAll();
		
		mav.addObject("listGrades", listGrades);
		mav.addObject("listEntreprises", listEntreprises);
		
		
		mav.setViewName("employes/creerEmploye");
		return mav;
	}
	
}
