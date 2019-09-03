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
 * Classe EntrepriseService
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
	 * en base de donnée sous la forme d'une EntrepriseVue (code + dénomination
	 * de l'entreprise)
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	public List<EntrepriseVue> afficherEntreprises() {
		// TODO Auto-generated method stub

		List<Entreprise> listeDesEntreprises = entrepriseRepository.findAll();
		List<EntrepriseVue> listeDesEntreprisesVue = new ArrayList<EntrepriseVue>();
		for (Entreprise entreprise : listeDesEntreprises) {
			listeDesEntreprisesVue.add(new EntrepriseVue(entreprise.getCode(), entreprise.getDenomination()));
		}
		logger.info(listeDesEntreprises.toString());

		return listeDesEntreprisesVue;
	}

	public Entreprise retrouverEntrepriseEnFonctionId(int id) {
		// TODO Auto-generated method stub

		return entrepriseRepository.findById(id);
	}

	public Entreprise retrouverEntrepriseEnFonctionCode(String code) {
		// TODO Auto-generated method stub

		return entrepriseRepository.findByCode(code);
	}

}
