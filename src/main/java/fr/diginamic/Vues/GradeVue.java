package fr.diginamic.Vues;

import java.math.BigDecimal;

/**
 * Classe GradeVue Elle est envoyée au front via l'objet
 * RemunerationEmployeReferentielsVue qu'elle caratérise.
 * 
 * représente une vue de l'objet Grade.
 * 
 * @author Diginamic02
 *
 */
public class GradeVue {

	public String code;
	public BigDecimal salaireAnnuel;

	/**
	 * Constructeur
	 * 
	 */
	public GradeVue() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param code
	 * @param salaireAnnuel
	 */
	public GradeVue(String code, BigDecimal salaireAnnuel) {
		super();
		this.code = code;
		this.salaireAnnuel = salaireAnnuel;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter
	 * 
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the salaireAnnuel
	 */
	public BigDecimal getSalaireAnnuel() {
		return salaireAnnuel;
	}

	/**
	 * Setter
	 * 
	 * @param salaireAnnuel
	 *            the salaireAnnuel to set
	 */
	public void setSalaireAnnuel(BigDecimal salaireAnnuel) {
		this.salaireAnnuel = salaireAnnuel;
	}

}
