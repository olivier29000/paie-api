package fr.diginamic.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.Vues.BulletinDeSalaireReferentielsVue;
import fr.diginamic.Vues.BulletinDeSalaireVue;
import fr.diginamic.Vues.EntrepriseVue;
import fr.diginamic.Vues.GradeVue;
import fr.diginamic.Vues.ProfilRemunerationVue;
import fr.diginamic.Vues.RemunerationEmployeReferentielsVue;
import fr.diginamic.Vues.RemunerationEmployeVue;
import fr.diginamic.paie.entites.BulletinDeSalaireCorpsPost;
import fr.diginamic.paie.entites.BulletinSalaire;
import fr.diginamic.paie.entites.Entreprise;
import fr.diginamic.paie.entites.Grade;
import fr.diginamic.paie.entites.Periode;
import fr.diginamic.paie.entites.ProfilRemuneration;
import fr.diginamic.paie.entites.RemunerationEmploye;
import fr.diginamic.paie.entites.RemunerationEmployeCorpsPost;
import fr.diginamic.services.BulletinDeSalaireReferentielsService;
import fr.diginamic.services.BulletinDeSalaireService;
import fr.diginamic.services.EntrepriseService;
import fr.diginamic.services.GradeService;
import fr.diginamic.services.PeriodeService;
import fr.diginamic.services.ProfilRemunerationService;
import fr.diginamic.services.RemunerationEmployeReferentielsService;
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
	RemunerationEmployeReferentielsService remunerationEmployeReferentielsService;
	@Autowired
	RemunerationEmployeService remunerationEmployeService;
	@Autowired
	BulletinDeSalaireReferentielsService bulletinDeSalaireReferentielsService;
	@Autowired
	PeriodeService periodeService;
	@Autowired
	BulletinDeSalaireService bulletinDeSalaireService;

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(PaieApiController.class);

	/**
	 * l'url .../referentiels_ajouter_un_employe permet de visualiser sous la
	 * forme d'un JSON la liste des entreprises, des grades, des profils de
	 * rémuneration présentes dans la base de donnée.
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	@RequestMapping(path = "/referentiel_bulletin_de_salaire", method = RequestMethod.GET)
	public BulletinDeSalaireReferentielsVue obtenirJsonReferentielsBulletinDeSalaire() {

		return bulletinDeSalaireReferentielsService.afficherReferentielsBulletinDeSalaire();
	}

	@RequestMapping(path = "/bulletin_de_salaire", method = RequestMethod.GET)
	public List<BulletinDeSalaireVue> obtenirJsonBulletinDeSalaire() {

		return bulletinDeSalaireService.obtenirListeBulletinDeSalaire();
	}

	@PostMapping(path = "/bulletin_de_salaire")
	public String reqBodyInsererBulletinDeSalaire(@RequestBody BulletinDeSalaireCorpsPost bulletinDeSalaireCorpsPost) {

		Periode periode = periodeService.retrouverPeriodeEnFonctionId(bulletinDeSalaireCorpsPost.getIdPeriode());

		RemunerationEmploye remunerationEmploye = remunerationEmployeService
				.retrouverRemunerationEmployeEnfonctionMatricule(bulletinDeSalaireCorpsPost.getMatricule());

		return bulletinDeSalaireService.ajouterBulletinDeSalaireEnBaseDeDonnee(
				new BulletinSalaire(remunerationEmploye, periode, bulletinDeSalaireCorpsPost.getPrimeExceptionnelle()));

		// tbjbjkl
	}

	/**
	 * l'url .../referentiels_ajouter_un_employe permet de visualiser sous la
	 * forme d'un JSON la liste des entreprises, des grades, des profils de
	 * rémuneration présentes dans la base de donnée.
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	@RequestMapping(path = "/referentiel_remuneration_employe", method = RequestMethod.GET)
	public RemunerationEmployeReferentielsVue obtenirJsonReferentielsRemunerationEmploye() {

		return remunerationEmployeReferentielsService.afficherReferentielsRemunerationEmploye();
	}

	/**
	 * l'url .../remuneration_employe permet de visualiser sous la forme d'une
	 * liste les rémunerationsEmployes dans la bdd l'url renvoi une liste de
	 * RemunerationEmployeVue sous la forme d'un JSON
	 * 
	 * @return une liste d'instances de RemunerationEmployeVue
	 */
	@RequestMapping(path = "/remuneration_employe", method = RequestMethod.GET)
	public List<RemunerationEmployeVue> listerLesRemunerationEmployeVue() {

		return remunerationEmployeService.afficherRemunerationEmployeVue();
	}

	/**
	 * Methode l'url .../entreprises permet de visualiser sous la forme d'un
	 * JSON la liste des entreprises présentes dans la base de donnée.
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	@RequestMapping(path = "/entreprises", method = RequestMethod.GET)
	public List<EntrepriseVue> reqParamEntreprises() {

		return entrepriseService.afficherEntreprises();
	}

	/**
	 * /grades permet de visualiser sous la forme d'un JSON la liste des grades
	 * présents dans la base de donnée.
	 * 
	 * 
	 * @return une liste d'instances de GradeVue
	 */
	@RequestMapping(path = "/grades", method = RequestMethod.GET)
	public List<GradeVue> reqParamGrades() {

		return gradeService.afficherGrades();
	}

	/**
	 * 
	 * /profilRemunerations permet de visualiser sous la forme d'un JSON la
	 * liste des ProdilRemuneration présents dans la base de donnée. des grades
	 * 
	 * @return une liste d'instances de ProdilRemunerationVue
	 */
	@RequestMapping(path = "/profilRemunerations", method = RequestMethod.GET)
	public List<ProfilRemunerationVue> reqParamProfilRemunerations() {

		return profilRemunerationService.afficherProfilRemunerations();
	}

	/**
	 * Methode Cette methode est activée par un POST sur l'url
	 * /ajouter_un_employe Le corps de la requete contient un JSON
	 * 
	 * @param corpsPostRemunerationEmploye
	 * @return
	 */
	@PostMapping(path = "/remuneration_employe")
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
