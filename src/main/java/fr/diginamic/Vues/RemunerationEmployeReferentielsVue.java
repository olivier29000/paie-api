package fr.diginamic.Vues;

import java.util.List;

/**
 * Classe RemunerationEmployeReferentielsVue Cette classe est envoyée au front
 * pour la construction de la page "ajouter un employé" url:
 * "/referentiel_remuneration_employe"
 * 
 * @author Diginamic02
 *
 */
public class RemunerationEmployeReferentielsVue {

	public List<EntrepriseVue> listeDesEntreprisesVue;
	public List<GradeVue> listeDesGradesVue;
	public List<ProfilRemunerationVue> listeDesProfilRemunerationsVue;

	/**
	 * Constructeur
	 * 
	 * @param listeDesEntreprises
	 * @param listeDesGrades
	 * @param listeDesProfilRemunerations
	 */
	public RemunerationEmployeReferentielsVue(List<EntrepriseVue> listeDesEntreprisesVue,
			List<GradeVue> listeDesGradesVue, List<ProfilRemunerationVue> listeDesProfilRemunerationsVue) {
		super();
		this.listeDesEntreprisesVue = listeDesEntreprisesVue;
		this.listeDesGradesVue = listeDesGradesVue;
		this.listeDesProfilRemunerationsVue = listeDesProfilRemunerationsVue;
	}

	/**
	 * @return the listeDesEntreprisesVue
	 */
	public List<EntrepriseVue> getListeDesEntreprisesVue() {
		return listeDesEntreprisesVue;
	}

	/**
	 * Setter
	 * 
	 * @param listeDesEntreprisesVue
	 *            the listeDesEntreprisesVue to set
	 */
	public void setListeDesEntreprisesVue(List<EntrepriseVue> listeDesEntreprisesVue) {
		this.listeDesEntreprisesVue = listeDesEntreprisesVue;
	}

	/**
	 * @return the listeDesGradesVue
	 */
	public List<GradeVue> getListeDesGradesVue() {
		return listeDesGradesVue;
	}

	/**
	 * Setter
	 * 
	 * @param listeDesGradesVue
	 *            the listeDesGradesVue to set
	 */
	public void setListeDesGradesVue(List<GradeVue> listeDesGradesVue) {
		this.listeDesGradesVue = listeDesGradesVue;
	}

	/**
	 * @return the listeDesProfilRemunerationsVue
	 */
	public List<ProfilRemunerationVue> getListeDesProfilRemunerationsVue() {
		return listeDesProfilRemunerationsVue;
	}

	/**
	 * Setter
	 * 
	 * @param listeDesProfilRemunerationsVue
	 *            the listeDesProfilRemunerationsVue to set
	 */
	public void setListeDesProfilRemunerationsVue(List<ProfilRemunerationVue> listeDesProfilRemunerationsVue) {
		this.listeDesProfilRemunerationsVue = listeDesProfilRemunerationsVue;
	}

}
