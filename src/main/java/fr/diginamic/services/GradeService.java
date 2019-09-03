package fr.diginamic.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.GradeVue;
import fr.diginamic.datajpa.GradeRepository;
import fr.diginamic.paie.entites.Grade;

@Service
public class GradeService {

	@Autowired
	private GradeRepository gradeRepository;

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EntrepriseService.class);

	/**
	 * Methode afficherEntreprises retourne la liste des entreprises présentes
	 * en base de donnée sous la forme d'une EntrepriseVue (code + dénomination
	 * de l'entreprise)
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	public List<GradeVue> afficherGrades() {
		// TODO Auto-generated method stub

		List<Grade> listeDesGrades = gradeRepository.findAll();
		List<GradeVue> listeDesGradesVue = new ArrayList<GradeVue>();
		for (Grade grade : listeDesGrades) {
			listeDesGradesVue.add(new GradeVue(grade.getCode(), grade.getNbHeuresBase().multiply(grade.getTauxBase())));
		}
		logger.info(listeDesGrades.toString());

		return listeDesGradesVue;
	}

	public Grade retrouverGradeEnFonctionId(int id) {
		// TODO Auto-generated method stub

		return gradeRepository.findById(id);
	}

	public Grade retrouverGradeEnFonctionCode(String code) {
		// TODO Auto-generated method stub

		return gradeRepository.findByCode(code);
	}

}
