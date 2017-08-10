package dev.paie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@RequestMapping(method = RequestMethod.GET, path="creer")
	public ModelAndView creerEmploye(){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("employes/creerEmploye");
		mav.addObject("prefixMatricule","M00");
		
		return mav;
	}
	
}
