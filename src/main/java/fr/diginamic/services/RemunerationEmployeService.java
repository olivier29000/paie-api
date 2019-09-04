package fr.diginamic.services;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.RemunerationEmployeVue;
import fr.diginamic.datajpa.RemunerationEmployeRepository;
import fr.diginamic.paie.entites.RemunerationEmploye;

/**
 * Ce service permet d'effectuer des requetes dans la table REMUNERATION_EMPLOYE
 * de la BDD
 * 
 * @author Diginamic02
 *
 */
@Service
public class RemunerationEmployeService {

	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	@Autowired
	private ApiCollegueService apiCollegueService;
	@Autowired
	private RemunerationEmployeService remunerationEmployeService;

	/**
	 * Cette Methode insère dans la table REMUNERATION_EMPLOYE de la BDD un
	 * objet RemunerationEmploye. Cette methode vérifie avant l'insertion si le
	 * matricule de l'objet RemunerationEmploye qu'on tente s'insérer correspond
	 * bien au matricule d'un des collegues présent dans l'api collegue (voir
	 * classe ApiCollegueService) Elle sert principalement sur la page "ajouter
	 * un employé" url: /remuneration_employe en POST
	 * 
	 * @param remunerationEmploye
	 * @return
	 */
	public String ajouterRemunerationEmployeEnBaseDeDonnee(RemunerationEmploye remunerationEmploye) {

		if (matriculeExisteDejaDansRemunerationEmploye(remunerationEmploye.getMatricule())) {
			return "{ \"message\" : \"le matricule est déjà présent dans la bdd Remuneration_Employe\" }";

		} else if (apiCollegueService.matriculeEmployeExisteChezApiCollegue(remunerationEmploye.getMatricule())) {
			remunerationEmploye.setDateHeureDeCreation(ZonedDateTime.now());
			remunerationEmployeRepository.save(remunerationEmploye);
			return "ok";
		} else {
			return "{ \"message\" : \"le matricule est absent de l'api collègue\" }";
		}

	}

	/**
	 * Cette methode renvoie une liste d'objets RemunerationEmployeVue qu'elle
	 * aura obtenu grâce à une liste d'objets RemunerationEmploye, eux même
	 * obtenus grâce à une requete dans la table REMUNERATION_EMPLOYE de la BDD
	 * Elle sert principalement sur la page "ajouter un employé" url:
	 * /remuneration_employe en GET
	 * 
	 * @return
	 */
	public List<RemunerationEmployeVue> obtenirListeDeRemunerationEmployeVue() {
		// TODO Auto-generated method stub
		List<RemunerationEmploye> listeDesRemunerationEmploye = remunerationEmployeRepository.findAll();
		List<RemunerationEmployeVue> listeDesRemunerationEmployeVue = new ArrayList<RemunerationEmployeVue>();
		for (RemunerationEmploye remunerationEmploye : listeDesRemunerationEmploye) {
			listeDesRemunerationEmployeVue.add(new RemunerationEmployeVue(remunerationEmploye.getDateHeureDeCreation(),
					remunerationEmploye.getMatricule(), remunerationEmploye.getGrade().getCode()));
		}
		return listeDesRemunerationEmployeVue;
	}

	/**
	 * Cette Methode vérifie si un matricule (en parametre) est présent dans la
	 * TABLE REMUNERATION_EMPLOYE de la BDD TRUE = le matricule est présent dans
	 * la table REMUNERATION_EMPLOYE
	 * 
	 * @param matricule
	 * @return
	 */
	public boolean matriculeExisteDejaDansRemunerationEmploye(String matricule) {
		boolean resultat = false;
		List<RemunerationEmploye> listeDesRemunerationEmploye = remunerationEmployeRepository.findAll();
		for (RemunerationEmploye remunerationEmploye : listeDesRemunerationEmploye) {
			if (remunerationEmploye.getMatricule().equals(matricule)) {
				resultat = true;
			}
		}
		return resultat;

	}

	/**
	 * Cette methode retourne un objet RemunerationEmploye de la table
	 * REMUNERATION_EMPLOYE dont le matricule correspond
	 * 
	 * @param matricule
	 * @return
	 */
	public RemunerationEmploye retrouverRemunerationEmployeEnfonctionMatricule(String matricule) {
		// TODO Auto-generated method stub
		return remunerationEmployeRepository.findByMatricule(matricule);
	}

}
