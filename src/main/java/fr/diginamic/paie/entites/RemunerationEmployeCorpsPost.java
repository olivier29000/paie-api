package fr.diginamic.paie.entites;

/**
 * Classe représentant le corps de la requete http lors de l'insertion d'une
 * RemunerationEmploye dans la bdd. grace à la méthode POST de l'url
 * "/remuneration_employe"
 * 
 * 
 * 
 * @author Diginamic02
 *
 */
public class RemunerationEmployeCorpsPost {

	private int id;
	private String matricule;
	private String codeEntreprise;
	private String codeProfilRemuneration;
	private String codeGrade;

	/**
	 * Constructeur
	 * 
	 * @param matricule
	 * @param codeEntreprise
	 * @param codeProfilRemuneration
	 * @param codeGrade
	 */
	public RemunerationEmployeCorpsPost(String matricule, String codeEntreprise, String codeProfilRemuneration,
			String codeGrade) {
		super();
		this.matricule = matricule;
		this.codeEntreprise = codeEntreprise;
		this.codeProfilRemuneration = codeProfilRemuneration;
		this.codeGrade = codeGrade;
	}

	/**
	 * Constructeur
	 * 
	 */
	public RemunerationEmployeCorpsPost() {
		super();
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Setter
	 * 
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the codeEntreprise
	 */
	public String getCodeEntreprise() {
		return codeEntreprise;
	}

	/**
	 * Setter
	 * 
	 * @param codeEntreprise
	 *            the codeEntreprise to set
	 */
	public void setCodeEntreprise(String codeEntreprise) {
		this.codeEntreprise = codeEntreprise;
	}

	/**
	 * @return the codeProfilRemuneration
	 */
	public String getCodeProfilRemuneration() {
		return codeProfilRemuneration;
	}

	/**
	 * Setter
	 * 
	 * @param codeProfilRemuneration
	 *            the codeProfilRemuneration to set
	 */
	public void setCodeProfilRemuneration(String codeProfilRemuneration) {
		this.codeProfilRemuneration = codeProfilRemuneration;
	}

	/**
	 * @return the codeGrade
	 */
	public String getCodeGrade() {
		return codeGrade;
	}

	/**
	 * Setter
	 * 
	 * @param codeGrade
	 *            the codeGrade to set
	 */
	public void setCodeGrade(String codeGrade) {
		this.codeGrade = codeGrade;
	}

}
