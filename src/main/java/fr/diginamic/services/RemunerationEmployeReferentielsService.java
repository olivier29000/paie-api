package fr.diginamic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.RemunerationEmployeReferentielsVue;
import fr.diginamic.Vues.EntrepriseVue;
import fr.diginamic.Vues.GradeVue;
import fr.diginamic.Vues.ProfilRemunerationVue;

@Service
public class RemunerationEmployeReferentielsService {

	@Autowired
	EntrepriseService entrepriseService;
	@Autowired
	GradeService gradeService;
	@Autowired
	ProfilRemunerationService profilRemunerationService;

	/**
	 * Methode afficherEntreprises retourne la liste des entreprises présentes
	 * en base de donnée sous la forme d'une EntrepriseVue (code + dénomination
	 * de l'entreprise)
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	public RemunerationEmployeReferentielsVue afficherReferentielsRemunerationEmploye() {
		// TODO Auto-generated method stub

		List<EntrepriseVue> listeDesEntreprisesVue = entrepriseService.afficherEntreprises();
		List<GradeVue> listeDesGradesVue = gradeService.afficherGrades();
		List<ProfilRemunerationVue> listeDesProfilRemunerationVue = profilRemunerationService
				.afficherProfilRemunerations();

		RemunerationEmployeReferentielsVue ajouterUnEmployeVue = new RemunerationEmployeReferentielsVue(listeDesEntreprisesVue, listeDesGradesVue,
				listeDesProfilRemunerationVue);

		return ajouterUnEmployeVue;
	}

}
