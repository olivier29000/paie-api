package fr.diginamic.paie.entites;

public class CorpsPostRemunerationEmploye {

	private int id;
	private String matricule;
	private int idEntreprise;
	private int idProfilRemuneration;
	private int idGrade;

	/**
	 * Constructeur
	 * 
	 */
	public CorpsPostRemunerationEmploye() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param matricule
	 * @param idEntreprise
	 * @param idProfilRemuneration
	 * @param idGrade
	 */
	public CorpsPostRemunerationEmploye(String matricule, int idEntreprise, int idProfilRemuneration, int idGrade) {
		super();
		this.matricule = matricule;
		this.idEntreprise = idEntreprise;
		this.idProfilRemuneration = idProfilRemuneration;
		this.idGrade = idGrade;
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
	 * @return the idEntreprise
	 */
	public int getIdEntreprise() {
		return idEntreprise;
	}

	/**
	 * Setter
	 * 
	 * @param idEntreprise
	 *            the idEntreprise to set
	 */
	public void setIdEntreprise(int idEntreprise) {
		this.idEntreprise = idEntreprise;
	}

	/**
	 * @return the idProfilRemuneration
	 */
	public int getIdProfilRemuneration() {
		return idProfilRemuneration;
	}

	/**
	 * Setter
	 * 
	 * @param idProfilRemuneration
	 *            the idProfilRemuneration to set
	 */
	public void setIdProfilRemuneration(int idProfilRemuneration) {
		this.idProfilRemuneration = idProfilRemuneration;
	}

	/**
	 * @return the idGrade
	 */
	public int getIdGrade() {
		return idGrade;
	}

	/**
	 * Setter
	 * 
	 * @param idGrade
	 *            the idGrade to set
	 */
	public void setIdGrade(int idGrade) {
		this.idGrade = idGrade;
	}

}
