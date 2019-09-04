package fr.diginamic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.Vues.ProfilRemunerationVue;
import fr.diginamic.services.ProfilRemunerationService;

@RestController
@RequestMapping(path = "/profilRemunerations")
public class ProfilRemunerationController {
	@Autowired
	ProfilRemunerationService profilRemunerationService;

	/**
	 * 
	 * /profilRemunerations permet de visualiser sous la forme d'un JSON la
	 * liste des ProfilsRemunerationVues (objet issu de ProfilsRemuneration
	 * présent dans la table PROFIL_REMUNERATION ). Le JSON retourné est de la
	 * forme: [ {"statut":"Technicien"}, {"statut":"Cadre"},
	 * {"statut":"Stagiaire"} ]
	 * 
	 * 
	 * @return une liste d'instances de ProfilRemunerationVue
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<ProfilRemunerationVue> reqParamProfilRemunerations() {

		return profilRemunerationService.obtenirListeProfilRemunerationsVue();
	}

}
