package fr.diginamic.Vues;

import java.time.ZonedDateTime;

import fr.diginamic.paie.entites.Periode;

public class BulletinDeSalaireVue {

	private ZonedDateTime dateHeureCreation;
	private Periode periode;
	private String matricule;
	private double salaireBrut;
	private double netImposable;
	private double netAPayer;

	/**
	 * Constructeur
	 * 
	 */
	public BulletinDeSalaireVue() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param dateHeureCreation
	 * @param periode
	 * @param matricule
	 * @param salaireBrut
	 * @param netImposable
	 * @param netAPayer
	 */
	public BulletinDeSalaireVue(ZonedDateTime dateHeureCreation, Periode periode, String matricule, double salaireBrut,
			double netImposable, double netAPayer) {
		super();
		this.dateHeureCreation = dateHeureCreation;
		this.periode = periode;
		this.matricule = matricule;
		this.salaireBrut = salaireBrut;
		this.netImposable = netImposable;
		this.netAPayer = netAPayer;
	}

	/**
	 * @return the dateHeureCreation
	 */
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	/**
	 * Setter
	 * 
	 * @param dateHeureCreation
	 *            the dateHeureCreation to set
	 */
	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	/**
	 * @return the periode
	 */
	public Periode getPeriode() {
		return periode;
	}

	/**
	 * Setter
	 * 
	 * @param periode
	 *            the periode to set
	 */
	public void setPeriode(Periode periode) {
		this.periode = periode;
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
	 * @return the salaireBrut
	 */
	public double getSalaireBrut() {
		return salaireBrut;
	}

	/**
	 * Setter
	 * 
	 * @param salaireBrut
	 *            the salaireBrut to set
	 */
	public void setSalaireBrut(double salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

	/**
	 * @return the netImposable
	 */
	public double getNetImposable() {
		return netImposable;
	}

	/**
	 * Setter
	 * 
	 * @param netImposable
	 *            the netImposable to set
	 */
	public void setNetImposable(double netImposable) {
		this.netImposable = netImposable;
	}

	/**
	 * @return the netAPayer
	 */
	public double getNetAPayer() {
		return netAPayer;
	}

	/**
	 * Setter
	 * 
	 * @param netAPayer
	 *            the netAPayer to set
	 */
	public void setNetAPayer(double netAPayer) {
		this.netAPayer = netAPayer;
	}

}
