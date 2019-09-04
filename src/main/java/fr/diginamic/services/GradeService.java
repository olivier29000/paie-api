package fr.diginamic.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.GradeVue;
import fr.diginamic.datajpa.GradeRepository;
import fr.diginamic.paie.entites.Grade;

/**
 * Ce service permet d'effectuer des reuqtes sur la table GRADE de la bdd Il est
 * principalement utilisé sur l'url "/grades" et dans la classe
 * RemunerationEmployeReferentielsService
 * 
 * @author Diginamic02
 *
 */
@Service
public class GradeService {

	@Autowired
	private GradeRepository gradeRepository;

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EntrepriseService.class);

	/**
	 * Methode Cette methode retourne une liste d'objets GradeVue qu'elle
	 * construit à partir d'une liste d'objets Grade Elle est principalement
	 * utilisée par la classe RemunerationEmployeReferentielService pour la
	 * construction de la page "ajouter un employé"
	 * url:"/referentiel_remuneration_employe"
	 * 
	 * 
	 * 
	 * @return une liste d'instances de EntrepriseVue
	 */
	public List<GradeVue> obtenirListeGrades() {
		// TODO Auto-generated method stub

		List<Grade> listeDesGrades = gradeRepository.findAll();
		List<GradeVue> listeDesGradesVue = new ArrayList<GradeVue>();
		for (Grade grade : listeDesGrades) {
			listeDesGradesVue.add(new GradeVue(grade.getCode(),
					grade.getNbHeuresBase().multiply(grade.getTauxBase()).multiply(new BigDecimal(12))));
		}
		logger.info(listeDesGrades.toString());

		return listeDesGradesVue;
	}

	public Grade retrouverGradeEnFonctionId(int id) {
		// TODO Auto-generated method stub

		return gradeRepository.findById(id);
	}

	/**
	 * Methode Cette methode effectue une requete dans la table GRADE de la BDD
	 * et retourne un objet Grade dont le code (en paramètre) correspond.
	 * 
	 * @param code
	 * @return
	 */
	public Grade retrouverGradeEnFonctionCode(String code) {
		// TODO Auto-generated method stub

		return gradeRepository.findByCode(code);
	}

}
