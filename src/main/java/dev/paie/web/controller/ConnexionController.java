package dev.paie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/connexion")
public class ConnexionController {

	
	@GetMapping 
	public String afficherPageCreer() {
	return "employes/connexion";
	}
	
	/*
	@RequestMapping(method = RequestMethod.POST, path="/logging")
	public ModelAndView loggingWIthTokenCSRF(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employes/connexion");
		
		if(token.equalsIgnoreCase("0f8bff7a-5930-4664-85e9-9fe0ff67fb26")){
			return new ModelAndView("redirect:employes/creerEmploye");
		}
		
		return mav;
		
		
	}
	*/
}
