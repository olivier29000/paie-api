package fr.diginamic.Vues;

import java.time.ZonedDateTime;

public class RemunerationEmployeVue {

	ZonedDateTime dateHeureDeCreation;
	String matricule;
	String grade;

	/**
	 * Constructeur
	 * 
	 */
	public RemunerationEmployeVue() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param dateHeureDeCreation
	 * @param matricule
	 * @param grade
	 */
	public RemunerationEmployeVue(ZonedDateTime dateHeureDeCreation, String matricule, String grade) {
		super();
		this.dateHeureDeCreation = dateHeureDeCreation;
		this.matricule = matricule;
		this.grade = grade;
	}

	/**
	 * @return the dateHeureDeCreation
	 */
	public ZonedDateTime getDateHeureDeCreation() {
		return dateHeureDeCreation;
	}

	/**
	 * Setter
	 * 
	 * @param dateHeureDeCreation
	 *            the dateHeureDeCreation to set
	 */
	public void setDateHeureDeCreation(ZonedDateTime dateHeureDeCreation) {
		this.dateHeureDeCreation = dateHeureDeCreation;
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
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * Setter
	 * 
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
