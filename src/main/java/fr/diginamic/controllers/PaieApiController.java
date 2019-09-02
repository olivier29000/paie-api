package fr.diginamic.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.Vues.AjouterUnEmployeVue;
import fr.diginamic.Vues.EntrepriseVue;
import fr.diginamic.Vues.GradeVue;
import fr.diginamic.Vues.ProfilRemunerationVue;
import fr.diginamic.entitesbdd.RemunerationEmployeBdd;
import fr.diginamic.paie.entites.CorpsPostRemunerationEmploye;
import fr.diginamic.services.AjouterUnEmployeService;
import fr.diginamic.services.EntrepriseService;
import fr.diginamic.services.GradeService;
import fr.diginamic.services.ProfilRemunerationService;
import fr.diginamic.services.RemunerationEmployeService;

/**
 * @author Diginamic02
 *
 */
@RestController
@RequestMapping
public class PaieApiController {

	@Autowired
	EntrepriseService entrepriseService;
	@Autowired
	GradeService gradeService;
	@Autowired
	ProfilRemunerationService profilRemunerationService;
	@Autowired
	AjouterUnEmployeService ajouterUnEmployeService;
	@Autowired
	RemunerationEmployeService remunerationEmployeService;

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(PaieApiController.class);

	/**
	 * 
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	@RequestMapping(path = "/referentiels_ajouter_un_employe", method = RequestMethod.GET)
	public AjouterUnEmployeVue reqParamAjouterUnEmploye() {

		return ajouterUnEmployeService.afficherAjouterUnEmploye();
	}

	/**
	 * Methode l'url .../entreprises permet de visualiser sous la forme d'un
	 * JSON la liste des entrprises présentes dans la base de donnée.
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	@RequestMapping(path = "/entreprises", method = RequestMethod.GET)
	public List<EntrepriseVue> reqParamEntreprises() {

		return entrepriseService.afficherEntreprises();
	}

	/**
	 * 
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	@RequestMapping(path = "/grades", method = RequestMethod.GET)
	public List<GradeVue> reqParamGrades() {

		return gradeService.afficherGrades();
	}

	/**
	 * 
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	@RequestMapping(path = "/profilRemunerations", method = RequestMethod.GET)
	public List<ProfilRemunerationVue> reqParamProfilRemunerations() {

		return profilRemunerationService.afficherProfilRemunerations();
	}

	@PostMapping(path = "/ajouter_un_employe")
	public String reqBodyInsererRemunerationEmploye(
			@RequestBody CorpsPostRemunerationEmploye corpsPostRemunerationEmploye) {

		remunerationEmployeService.ajouterRemunerationEmployeEnBaseDeDonnee(new RemunerationEmployeBdd(
				corpsPostRemunerationEmploye.getMatricule(), corpsPostRemunerationEmploye.getEntreprise(),
				corpsPostRemunerationEmploye.getProfilRemuneration(), corpsPostRemunerationEmploye.getGrade()));

		return "ok";

		// tbjbjkl
	}

}
