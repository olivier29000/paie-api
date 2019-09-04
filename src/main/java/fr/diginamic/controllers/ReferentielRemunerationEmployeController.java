package fr.diginamic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.Vues.RemunerationEmployeReferentielsVue;
import fr.diginamic.services.RemunerationEmployeReferentielsService;

@RestController
@RequestMapping(path = "/referentiel_remuneration_employe")
public class ReferentielRemunerationEmployeController {

	@Autowired
	RemunerationEmployeReferentielsService remunerationEmployeReferentielsService;

	/**
	 * l'url .../referentiels_ajouter_un_employe permet de visualiser sous la
	 * forme d'un JSON la liste des entreprises, des grades, des profils de
	 * rémuneration présentes dans la base de donnée. le JSON est de la forme: {
	 * "listeDesEntreprisesVue": [ {"code":"DEV","denomination":"Dev Institut"},
	 * {"code":"SOP","denomination":"Sopra-Steria"},
	 * {"code":"CAP","denomination":"Capgemini"}], "listeDesGradesVue":[
	 * {"code":"GRADE_A","salaireAnnuel":1672.0000},
	 * {"code":"GRADE_B","salaireAnnuel":3192.0000},
	 * {"code":"GRADE_C","salaireAnnuel":4712.0000} ],
	 * "listeDesProfilRemunerationsVue": [ {"statut":"Technicien"},
	 * {"statut":"Cadre"}, {"statut":"Stagiaire"} ], "listeDesGrades": [
	 * {"code":"GRADE_A","salaireAnnuel":1672.0000},
	 * {"code":"GRADE_B","salaireAnnuel":3192.0000},
	 * {"code":"GRADE_C","salaireAnnuel":4712.0000} ],
	 * "listeDesProfilRemunerations": [ {"statut":"Technicien"},
	 * {"statut":"Cadre"}, {"statut":"Stagiaire"} ], "listeDesEntreprises": [
	 * {"code":"DEV","denomination":"Dev Institut"},
	 * {"code":"SOP","denomination":"Sopra-Steria"},
	 * {"code":"CAP","denomination":"Capgemini"} ] }
	 *
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	@RequestMapping(method = RequestMethod.GET)
	public RemunerationEmployeReferentielsVue obtenirJsonReferentielsRemunerationEmploye() {

		return remunerationEmployeReferentielsService.obtenirListeDesRemunerationEmployeReferentielsVue();
	}

}
