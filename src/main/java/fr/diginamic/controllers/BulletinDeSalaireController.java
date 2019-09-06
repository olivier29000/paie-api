package fr.diginamic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.Vues.BulletinDeSalaireCompletVue;
import fr.diginamic.Vues.BulletinDeSalaireVue;
import fr.diginamic.paie.entites.BulletinDeSalaireCorpsPost;
import fr.diginamic.paie.entites.BulletinSalaire;
import fr.diginamic.paie.entites.Periode;
import fr.diginamic.paie.entites.RemunerationEmploye;
import fr.diginamic.services.BulletinDeSalaireService;
import fr.diginamic.services.PeriodeService;
import fr.diginamic.services.RemunerationEmployeService;

@RestController

@RequestMapping(path = "/bulletin_de_salaire")
public class BulletinDeSalaireController {

	@Autowired
	BulletinDeSalaireService bulletinDeSalaireService;
	@Autowired
	PeriodeService periodeService;
	@Autowired
	RemunerationEmployeService remunerationEmployeService;

	/**
	 * Methode Cette methode sert à la construction de la page "liste des
	 * bulletins de salaires" url: "/bulletin_de_salaire" Elle renvoie une liste
	 * de BulletinDeSalaireVue qui serviront à la construction d'une liste dans
	 * le front. Un BulletinDeSalaireVue représente une ligne de cette liste
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<BulletinDeSalaireVue> obtenirJsonBulletinDeSalaire() {

		return bulletinDeSalaireService.obtenirListeBulletinDeSalaireVues();
	}

	/**
	 * Methode Cette methode est appelée pour l'insertion d'un nouveau bulletin
	 * de salaire, page "créer u nbulletin de salaire" url:
	 * "/bulletin_de_salaire" en POST Elle retourne le string "ok" (quoi qu'il
	 * arrive pour l'instant...)
	 * 
	 * @param bulletinDeSalaireCorpsPost
	 * @return
	 */
	@PostMapping
	public String reqBodyInsererBulletinDeSalaire(@RequestBody BulletinDeSalaireCorpsPost bulletinDeSalaireCorpsPost) {

		Periode periode = periodeService.retrouverPeriodeEnFonctionId(bulletinDeSalaireCorpsPost.getIdPeriode());

		RemunerationEmploye remunerationEmploye = remunerationEmployeService
				.retrouverRemunerationEmployeEnfonctionMatricule(bulletinDeSalaireCorpsPost.getMatricule());

		return bulletinDeSalaireService.ajouterBulletinDeSalaireEnBaseDeDonnee(
				new BulletinSalaire(remunerationEmploye, periode, bulletinDeSalaireCorpsPost.getPrimeExceptionnelle()));

		// tbjbjkl
	}

	@RequestMapping(method = RequestMethod.GET, params = { "code" })
	public BulletinDeSalaireCompletVue reqBulletinDeSalaireCompletVue(@RequestParam String codeBulletinDeSalaire) {

		return bulletinDeSalaireService.obtenirBulletinDeSalaireCompletVue(codeBulletinDeSalaire);
	}

}
