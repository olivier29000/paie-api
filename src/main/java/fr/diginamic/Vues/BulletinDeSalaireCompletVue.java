package fr.diginamic.Vues;

import java.math.BigDecimal;

import fr.diginamic.paie.entites.BulletinSalaire;
import fr.diginamic.paie.entites.Collegue;

public class BulletinDeSalaireCompletVue {

	private Collegue collegue;
	private BulletinSalaire bulletinSalaire;
	private BigDecimal primeExceptionnelle;

	/**
	 * Constructeur
	 * 
	 * @param collegue
	 * @param bulletinSalaire
	 * @param primeExceptionnelle
	 */
	public BulletinDeSalaireCompletVue(Collegue collegue, BulletinSalaire bulletinSalaire,
			BigDecimal primeExceptionnelle) {
		super();
		this.collegue = collegue;
		this.bulletinSalaire = bulletinSalaire;
		this.primeExceptionnelle = primeExceptionnelle;
	}

	/**
	 * @return the collegue
	 */
	public Collegue getCollegue() {
		return collegue;
	}

	/**
	 * Setter
	 * 
	 * @param collegue
	 *            the collegue to set
	 */
	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
	}

	/**
	 * @return the bulletinSalaire
	 */
	public BulletinSalaire getBulletinSalaire() {
		return bulletinSalaire;
	}

	/**
	 * Setter
	 * 
	 * @param bulletinSalaire
	 *            the bulletinSalaire to set
	 */
	public void setBulletinSalaire(BulletinSalaire bulletinSalaire) {
		this.bulletinSalaire = bulletinSalaire;
	}

	/**
	 * @return the primeExceptionnelle
	 */
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

	/**
	 * Setter
	 * 
	 * @param primeExceptionnelle
	 *            the primeExceptionnelle to set
	 */
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}

}
