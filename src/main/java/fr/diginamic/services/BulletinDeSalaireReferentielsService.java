package fr.diginamic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.BulletinDeSalaireReferentielsVue;
import fr.diginamic.Vues.PeriodeVue;
import fr.diginamic.Vues.RemunerationEmployeVue;

/**
 * Cette classe permet d'envoyer les information necessaire au front pour la
 * construction de la page "Creer bulletin de salaire" Cette page a besoin/Ce
 * service permet l'envoi: _de la liste des périodes en BDD _de la liste des
 * matricules présents dans la table REMUNERATION_EMPLOYE en BDD
 * 
 * 
 * @author Diginamic02
 *
 */
@Service
public class BulletinDeSalaireReferentielsService {

	@Autowired
	private PeriodeService periodeService;
	@Autowired
	private RemunerationEmployeService remunerationEmployeService;

	/**
	 * Methode Cette methode permet d'obtenir la liste des périodes en BDD, la
	 * liste des matricules présents dans la table REMUNERATION_EMPLOYE en BDD
	 * sous la forme d'un objet BulletinDeSalaireReferentielsVue qui est renvoyé
	 * 
	 * @return
	 */
	public BulletinDeSalaireReferentielsVue afficherReferentielsBulletinDeSalaire() {
		List<PeriodeVue> listeDePeriode = periodeService.obtenirListeDePeriodesVue();
		List<RemunerationEmployeVue> listeDeRemunerationEmployeVue = remunerationEmployeService
				.obtenirListeDeRemunerationEmployeVue();
		List<String> listeDeMatricules = new ArrayList<String>();

		for (RemunerationEmployeVue remunerationEmployeVue : listeDeRemunerationEmployeVue) {
			listeDeMatricules.add(remunerationEmployeVue.getMatricule());
		}
		return new BulletinDeSalaireReferentielsVue(listeDePeriode, listeDeMatricules);
	}

}
