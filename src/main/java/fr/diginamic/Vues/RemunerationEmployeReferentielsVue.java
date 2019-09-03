package fr.diginamic.Vues;

import java.util.List;

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
	public RemunerationEmployeReferentielsVue(List<EntrepriseVue> listeDesEntreprisesVue, List<GradeVue> listeDesGradesVue,
			List<ProfilRemunerationVue> listeDesProfilRemunerationsVue) {
		super();
		this.listeDesEntreprisesVue = listeDesEntreprisesVue;
		this.listeDesGradesVue = listeDesGradesVue;
		this.listeDesProfilRemunerationsVue = listeDesProfilRemunerationsVue;
	}

	/**
	 * @return the listeDesEntreprises
	 */
	public List<EntrepriseVue> getListeDesEntreprises() {
		return listeDesEntreprisesVue;
	}

	/**
	 * Setter
	 * 
	 * @param listeDesEntreprises
	 *            the listeDesEntreprises to set
	 */
	public void setListeDesEntreprises(List<EntrepriseVue> listeDesEntreprises) {
		this.listeDesEntreprisesVue = listeDesEntreprises;
	}

	/**
	 * @return the listeDesGrades
	 */
	public List<GradeVue> getListeDesGrades() {
		return listeDesGradesVue;
	}

	/**
	 * Setter
	 * 
	 * @param listeDesGrades
	 *            the listeDesGrades to set
	 */
	public void setListeDesGrades(List<GradeVue> listeDesGrades) {
		this.listeDesGradesVue = listeDesGrades;
	}

	/**
	 * @return the listeDesProfilRemunerations
	 */
	public List<ProfilRemunerationVue> getListeDesProfilRemunerations() {
		return listeDesProfilRemunerationsVue;
	}

	/**
	 * Setter
	 * 
	 * @param listeDesProfilRemunerations
	 *            the listeDesProfilRemunerations to set
	 */
	public void setListeDesProfilRemunerations(List<ProfilRemunerationVue> listeDesProfilRemunerations) {
		this.listeDesProfilRemunerationsVue = listeDesProfilRemunerations;
	}

}
