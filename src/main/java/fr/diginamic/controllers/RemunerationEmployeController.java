package fr.diginamic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.Vues.RemunerationEmployeVue;
import fr.diginamic.paie.entites.Entreprise;
import fr.diginamic.paie.entites.Grade;
import fr.diginamic.paie.entites.ProfilRemuneration;
import fr.diginamic.paie.entites.RemunerationEmploye;
import fr.diginamic.paie.entites.RemunerationEmployeCorpsPost;
import fr.diginamic.services.EntrepriseService;
import fr.diginamic.services.GradeService;
import fr.diginamic.services.ProfilRemunerationService;
import fr.diginamic.services.RemunerationEmployeService;

@RestController
@RequestMapping(path = "/remuneration_employe")
public class RemunerationEmployeController {

	@Autowired
	RemunerationEmployeService remunerationEmployeService;
	@Autowired
	EntrepriseService entrepriseService;
	@Autowired
	GradeService gradeService;
	@Autowired
	ProfilRemunerationService profilRemunerationService;

	/**
	 * l'url .../remuneration_employe permet de visualiser sous la forme d'une
	 * liste les rémunerationsEmployesVue. l'url renvoi une liste de
	 * RemunerationEmployeVue sous la forme d'un JSON de cette forme: [
	 * {"dateHeureDeCreation":"2019-09-04T14:16:36.92+02:00","matricule":"1b60b96d-6519-428d-afb2-b6aa5b344c3e","grade":"GRADE_A"},
	 * {"dateHeureDeCreation":"2019-09-04T14:22:29.536+02:00","matricule":"70428cb5-0ed7-4d30-91a7-6a8de50a94dc","grade":"GRADE_B"}
	 * ]
	 * 
	 * @return une liste d'instances de RemunerationEmployeVue
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<RemunerationEmployeVue> listerLesRemunerationEmployeVue() {

		return remunerationEmployeService.obtenirListeDeRemunerationEmployeVue();
	}

	/**
	 * Methode Cette methode est activée par un POST sur l'url
	 * /remuneration_employe. Le corps de la requete doit contenir un JSON de la
	 * forme:
	 * 
	 * { "matricule" : "1b60b96d-6519-428d-afb2-b6aa5b344c3e", "codeEntreprise"
	 * : "DEV", "codeProfilRemuneration" : "Cadre", "codeGrade" : "GRADE_A" }
	 * 
	 * @param corpsPostRemunerationEmploye
	 * @return
	 */
	@PostMapping
	public String reqBodyInsererRemunerationEmploye(
			@RequestBody RemunerationEmployeCorpsPost corpsPostRemunerationEmploye) {

		Entreprise entreprise = entrepriseService
				.retrouverEntrepriseEnFonctionCode(corpsPostRemunerationEmploye.getCodeEntreprise());
		ProfilRemuneration profilRemuneration = profilRemunerationService
				.retrouverProfilRemunerationEnFonctionCode(corpsPostRemunerationEmploye.getCodeProfilRemuneration());
		Grade grade = gradeService.retrouverGradeEnFonctionCode(corpsPostRemunerationEmploye.getCodeGrade());

		RemunerationEmploye remunerationEmploye = new RemunerationEmploye(corpsPostRemunerationEmploye.getMatricule(),
				entreprise, profilRemuneration, grade);

		return remunerationEmployeService.ajouterRemunerationEmployeEnBaseDeDonnee(remunerationEmploye);

		// tbjbjkl
	}

}
