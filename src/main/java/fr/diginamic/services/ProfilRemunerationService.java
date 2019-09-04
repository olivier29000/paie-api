package fr.diginamic.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.ProfilRemunerationVue;
import fr.diginamic.datajpa.ProfilRemunerationRepository;
import fr.diginamic.paie.entites.ProfilRemuneration;

/**
 * Ce service permet d'effectuer des requetes sur la table PROFIL_REMUNERATION
 * de la BDD
 * 
 * @author Diginamic02
 *
 */
@Service
public class ProfilRemunerationService {

	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ProfilRemunerationService.class);

	/**
	 * Methode Cette methode retourne une liste d'objets ProfilRemunerationVue
	 * qu'elle aura obtenu à partir d'une liste d'objets ProfilRemuneration, eux
	 * même obtenus grâce à une requete sur la table PROFIL_REMUNERATION de la
	 * BDD. Cette methode sert principalement dans la classe
	 * RemunerationEmployeReferentielService afin de construire le front de la
	 * page "ajouter un employé" url:"/referentiel_remuneration_employe"
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	public List<ProfilRemunerationVue> obtenirListeProfilRemunerationsVue() {
		// TODO Auto-generated method stub

		List<ProfilRemuneration> listeDesProfilRemunerations = profilRemunerationRepository.findAll();
		List<ProfilRemunerationVue> listeDesProfilRemunerationVue = new ArrayList<ProfilRemunerationVue>();
		for (ProfilRemuneration profilRemuneration : listeDesProfilRemunerations) {
			listeDesProfilRemunerationVue.add(new ProfilRemunerationVue(profilRemuneration.getCode()));
		}
		logger.info(listeDesProfilRemunerations.toString());

		return listeDesProfilRemunerationVue;
	}

	public ProfilRemuneration retrouverProfilRemunerationEnFonctionId(int id) {
		// TODO Auto-generated method stub

		return profilRemunerationRepository.findById(id);
	}

	/**
	 * Cette methode retourne un objet ProfilRemuneration correspondant à un
	 * code grâce a une requete dans la table PROFIL_REMUNERATION de la BDD
	 * 
	 * @param code
	 * @return
	 */
	public ProfilRemuneration retrouverProfilRemunerationEnFonctionCode(String code) {
		// TODO Auto-generated method stub

		return profilRemunerationRepository.findByCode(code);
	}

}
