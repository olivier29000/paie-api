package fr.diginamic.Vues;

import java.util.List;

public class AjouterUnEmployeVue {

	public List<EntrepriseVue> listeDesEntreprises;
	public List<GradeVue> listeDesGrades;
	public List<ProfilRemunerationVue> listeDesProfilRemunerations;

	/**
	 * Constructeur
	 * 
	 * @param listeDesEntreprises
	 * @param listeDesGrades
	 * @param listeDesProfilRemunerations
	 */
	public AjouterUnEmployeVue(List<EntrepriseVue> listeDesEntreprises, List<GradeVue> listeDesGrades,
			List<ProfilRemunerationVue> listeDesProfilRemunerations) {
		super();
		this.listeDesEntreprises = listeDesEntreprises;
		this.listeDesGrades = listeDesGrades;
		this.listeDesProfilRemunerations = listeDesProfilRemunerations;
	}

	/**
	 * @return the listeDesEntreprises
	 */
	public List<EntrepriseVue> getListeDesEntreprises() {
		return listeDesEntreprises;
	}

	/**
	 * Setter
	 * 
	 * @param listeDesEntreprises
	 *            the listeDesEntreprises to set
	 */
	public void setListeDesEntreprises(List<EntrepriseVue> listeDesEntreprises) {
		this.listeDesEntreprises = listeDesEntreprises;
	}

	/**
	 * @return the listeDesGrades
	 */
	public List<GradeVue> getListeDesGrades() {
		return listeDesGrades;
	}

	/**
	 * Setter
	 * 
	 * @param listeDesGrades
	 *            the listeDesGrades to set
	 */
	public void setListeDesGrades(List<GradeVue> listeDesGrades) {
		this.listeDesGrades = listeDesGrades;
	}

	/**
	 * @return the listeDesProfilRemunerations
	 */
	public List<ProfilRemunerationVue> getListeDesProfilRemunerations() {
		return listeDesProfilRemunerations;
	}

	/**
	 * Setter
	 * 
	 * @param listeDesProfilRemunerations
	 *            the listeDesProfilRemunerations to set
	 */
	public void setListeDesProfilRemunerations(List<ProfilRemunerationVue> listeDesProfilRemunerations) {
		this.listeDesProfilRemunerations = listeDesProfilRemunerations;
	}

}
