package fr.diginamic.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.EntrepriseVue;
import fr.diginamic.datajpa.EntrepriseRepository;
import fr.diginamic.paie.entites.Entreprise;

@Service
public class EntrepriseService {

	@Autowired
	private EntrepriseRepository entrepriseRepository;

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EntrepriseService.class);

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

}
