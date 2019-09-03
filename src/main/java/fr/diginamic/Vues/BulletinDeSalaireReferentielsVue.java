package fr.diginamic.Vues;

import java.util.List;

public class BulletinDeSalaireReferentielsVue {

	public List<PeriodeVue> periode;
	public List<String> matricule;

	/**
	 * Constructeur
	 * 
	 * @param periode
	 * @param matricule
	 */
	public BulletinDeSalaireReferentielsVue(List<PeriodeVue> periode, List<String> matricule) {
		super();
		this.periode = periode;
		this.matricule = matricule;
	}

	/**
	 * Constructeur
	 * 
	 */
	public BulletinDeSalaireReferentielsVue() {
		super();
	}

	/**
	 * @return the periode
	 */
	public List<PeriodeVue> getPeriode() {
		return periode;
	}

	/**
	 * Setter
	 * 
	 * @param periode
	 *            the periode to set
	 */
	public void setPeriode(List<PeriodeVue> periode) {
		this.periode = periode;
	}

	/**
	 * @return the matricule
	 */
	public List<String> getMatricule() {
		return matricule;
	}

	/**
	 * Setter
	 * 
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(List<String> matricule) {
		this.matricule = matricule;
	}

}
