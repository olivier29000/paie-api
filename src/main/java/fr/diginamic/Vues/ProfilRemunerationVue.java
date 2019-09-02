package fr.diginamic.Vues;

public class ProfilRemunerationVue {

	public String statut;

	/**
	 * Constructeur
	 * 
	 */
	public ProfilRemunerationVue() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param statut
	 */
	public ProfilRemunerationVue(String statut) {
		super();
		this.statut = statut;
	}

	/**
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * Setter
	 * 
	 * @param statut
	 *            the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}

}
