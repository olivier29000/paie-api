package fr.diginamic.Vues;

import java.time.LocalDate;

/**
 * Cette classe représente la vue (front) d'un objet Periode. Elle est envoyée
 * au front via l'objet BulletinDeSalaireReferentielsVue qu'elle caracterise.
 * 
 * @author Diginamic02
 *
 */
public class PeriodeVue {

	int id;
	LocalDate dateDebut;
	LocalDate dateFin;

	/**
	 * Constructeur
	 * 
	 */
	public PeriodeVue() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param dateDebut
	 * @param dateFin
	 */
	public PeriodeVue(LocalDate dateDebut, LocalDate dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	/**
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * Setter
	 * 
	 * @param dateDebut
	 *            the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * Setter
	 * 
	 * @param dateFin
	 *            the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
