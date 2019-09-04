package fr.diginamic.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.EntrepriseVue;
import fr.diginamic.datajpa.EntrepriseRepository;
import fr.diginamic.paie.entites.Entreprise;

/**
 * Ce Service permet d'effectuer des requetes dans la table ENTREPRISE de la BDD
 * Il est principalement utilisé sur l'url "/entreprises" et dans la classe
 * RemunerationEmployeReferentielsService
 * 
 * @author Diginamic02
 *
 */
@Service
public class EntrepriseService {

	@Autowired
	private EntrepriseRepository entrepriseRepository;

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EntrepriseService.class);

	/**
	 * Methode afficherEntreprises retourne la liste des entreprises présentes
	 * dans la table NETREPRISE de la BDD sous la forme d'un objet EntrepriseVue
	 * (code + dénomination de l'entreprise)
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	public List<EntrepriseVue> obtenirListeEntreprisesVues() {
		// TODO Auto-generated method stub

		List<Entreprise> listeDesEntreprises = entrepriseRepository.findAll();
		List<EntrepriseVue> listeDesEntreprisesVue = new ArrayList<EntrepriseVue>();
		for (Entreprise entreprise : listeDesEntreprises) {
			listeDesEntreprisesVue.add(new EntrepriseVue(entreprise.getCode(), entreprise.getDenomination()));
		}
		logger.info(listeDesEntreprises.toString());

		return listeDesEntreprisesVue;
	}

	/**
	 * Methode Cette methode retourne un objet Entreprise en fonction d'un ID
	 * 
	 * @param id
	 * @return
	 */
	public Entreprise retrouverEntrepriseEnFonctionId(int id) {
		// TODO Auto-generated method stub

		return entrepriseRepository.findById(id);
	}

	/**
	 * Methode Cette methode retourne un objet Entreprise (table ENTREPRISE de
	 * la BDD) en fonction d'un CODE
	 * 
	 * @param code
	 * @return
	 */
	public Entreprise retrouverEntrepriseEnFonctionCode(String code) {
		// TODO Auto-generated method stub

		return entrepriseRepository.findByCode(code);
	}

}
