package fr.diginamic.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.ProfilRemunerationVue;
import fr.diginamic.datajpa.ProfilRemunerationRepository;
import fr.diginamic.paie.entites.ProfilRemuneration;

@Service
public class ProfilRemunerationService {

	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ProfilRemunerationService.class);

	/**
	 * Methode afficherEntreprises retourne la liste des entreprises présentes
	 * en base de donnée sous la forme d'une EntrepriseVue (code + dénomination
	 * de l'entreprise)
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	public List<ProfilRemunerationVue> afficherProfilRemunerations() {
		// TODO Auto-generated method stub

		List<ProfilRemuneration> listeDesProfilRemunerations = profilRemunerationRepository.findAll();
		List<ProfilRemunerationVue> listeDesProfilRemunerationVue = new ArrayList<ProfilRemunerationVue>();
		for (ProfilRemuneration profilRemuneration : listeDesProfilRemunerations) {
			listeDesProfilRemunerationVue.add(new ProfilRemunerationVue(profilRemuneration.getCode()));
		}
		logger.info(listeDesProfilRemunerations.toString());

		return listeDesProfilRemunerationVue;
	}

}
