package fr.diginamic.paie.entites;

import java.math.BigDecimal;

public class BulletinDeSalaireCorpsPost {

	public Integer idPeriode;
	public String matricule;
	public BigDecimal primeExceptionnelle;

	/**
	 * Constructeur
	 * 
	 */
	public BulletinDeSalaireCorpsPost() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param idPeriode
	 * @param matricule
	 * @param primeExceptionnelle
	 */
	public BulletinDeSalaireCorpsPost(Integer idPeriode, String matricule, BigDecimal primeExceptionnelle) {
		super();
		this.idPeriode = idPeriode;
		this.matricule = matricule;
		this.primeExceptionnelle = primeExceptionnelle;
	}

	/**
	 * @return the idPeriode
	 */
	public Integer getIdPeriode() {
		return idPeriode;
	}

	/**
	 * Setter
	 * 
	 * @param idPeriode
	 *            the idPeriode to set
	 */
	public void setIdPeriode(Integer idPeriode) {
		this.idPeriode = idPeriode;
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
