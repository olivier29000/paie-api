package fr.diginamic.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.paie.entites.Entreprise;
import fr.diginamic.services.EntrepriseService;

@RestController
@RequestMapping(path = "/entreprises")
public class PaieApiController {

	@Autowired
	EntrepriseService entrepriseService;
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(PaieApiController.class);

	@RequestMapping(method = RequestMethod.GET)
	public List<Entreprise> reqParam() {

		return entrepriseService.afficherEntreprises();
	}
}
