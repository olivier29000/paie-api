package fr.diginamic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.Vues.EntrepriseVue;
import fr.diginamic.services.EntrepriseService;

@RestController
@Secured("ROLE_ADMIN")
@RequestMapping(path = "/entreprise")
public class EntrepriseController {

	@Autowired
	EntrepriseService entrepriseService;

	/**
	 * Methode l'url .../entreprises permet de visualiser sous la forme d'un
	 * JSON la liste des entreprises présentes dans la base de donnée. Le JSON
	 * retourné est de la forme: [ {"code":"DEV","denomination":"Dev Institut"},
	 * {"code":"SOP","denomination":"Sopra-Steria"},
	 * {"code":"CAP","denomination":"Capgemini"}]
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<EntrepriseVue> reqParamEntreprises() {

		return entrepriseService.obtenirListeEntreprisesVues();
	}

}
