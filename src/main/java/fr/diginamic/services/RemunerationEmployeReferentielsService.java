package fr.diginamic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.EntrepriseVue;
import fr.diginamic.Vues.GradeVue;
import fr.diginamic.Vues.ProfilRemunerationVue;
import fr.diginamic.Vues.RemunerationEmployeReferentielsVue;

/**
 * 
 * Cette classe permet d'envoyer les information necessaire au front pour la
 * construction de la page "ajouter un employé" Cette page a besoin/Ce service
 * permet l'envoi: _de la liste des entreprisess en BDD _de la liste des profils
 * (de rémunerations) présents en BDD _de la liste des grades présents en BDD
 * 
 * @author Diginamic02
 *
 */
@Service
public class RemunerationEmployeReferentielsService {

	@Autowired
	EntrepriseService entrepriseService;
	@Autowired
	GradeService gradeService;
	@Autowired
	ProfilRemunerationService profilRemunerationService;

	/**
	 * Methode Cette methode permet d'obtenir la liste des entreprisess en BDD,
	 * la liste des profils (de rémunerations) présents en BDD, la liste des
	 * grades présents en BDD sous la forme d'un objet
	 * BulletinDeSalaireReferentielsVue
	 * 
	 * @return
	 */
	public RemunerationEmployeReferentielsVue obtenirListeDesRemunerationEmployeReferentielsVue() {
		// TODO Auto-generated method stub

		List<EntrepriseVue> listeDesEntreprisesVue = entrepriseService.obtenirListeEntreprisesVues();
		List<GradeVue> listeDesGradesVue = gradeService.obtenirListeGrades();
		List<ProfilRemunerationVue> listeDesProfilRemunerationVue = profilRemunerationService
				.obtenirListeProfilRemunerationsVue();

		RemunerationEmployeReferentielsVue ajouterUnEmployeVue = new RemunerationEmployeReferentielsVue(
				listeDesEntreprisesVue, listeDesGradesVue, listeDesProfilRemunerationVue);

		return ajouterUnEmployeVue;
	}

}
