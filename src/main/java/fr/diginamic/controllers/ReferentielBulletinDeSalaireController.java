package fr.diginamic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.Vues.BulletinDeSalaireReferentielsVue;
import fr.diginamic.services.BulletinDeSalaireReferentielsService;

@RestController
@Secured("ROLE_ADMIN")
@RequestMapping(path = "/referentiel_bulletin_de_salaire")
public class ReferentielBulletinDeSalaireController {

	@Autowired
	BulletinDeSalaireReferentielsService bulletinDeSalaireReferentielsService;

	/**
	 * Cette méthode est appellée pour la construction de la page "ajouter un
	 * bulletin de salaire" url: "/referentiel_bulletin_de_salaire" Elle permet
	 * au front de remplir les combobox avec la liste des matricules présents
	 * dans la table REMUNERATION_EMPLOYE et la liste des periodes (table
	 * PERIODE)
	 * 
	 * 
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	@RequestMapping(method = RequestMethod.GET)
	public BulletinDeSalaireReferentielsVue obtenirJsonReferentielsBulletinDeSalaire() {

		return bulletinDeSalaireReferentielsService.afficherReferentielsBulletinDeSalaire();
	}

}
