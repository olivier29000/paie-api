package fr.diginamic.Vues;

public class EntrepriseVue {

	private String code;
	private String denomination;

	/**
	 * Constructeur
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
