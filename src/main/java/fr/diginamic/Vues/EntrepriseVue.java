package fr.diginamic.Vues;

/**
 * représente une vue de l'objet Entreprise. Cette vue est caractérisée par code
 * et dénomination qui sont eux même des attributs de l'objet Entreprise
 * 
 * @author Diginamic02
 *
 */
public class EntrepriseVue {

	/** code : code de l'entreprise String */
	private String code;
	/** denomination : dénomination ou nom de l'entreprise String */
	private String denomination;

	/**
	 * Constructeur permettant de créer une instance de EntrepriseVue avec les
	 * attributs code et dénomination
	 * 
	 * @param code
	 * @param denomination
	 */
	public EntrepriseVue(String code, String denomination) {
		super();
		this.code = code;
		this.denomination = denomination;
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
	 * @return the denomination
	 */
	public String getDenomination() {
		return denomination;
	}

	/**
	 * Setter
	 * 
	 * @param denomination
	 *            the denomination to set
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

}
