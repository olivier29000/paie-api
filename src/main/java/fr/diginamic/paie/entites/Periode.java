package fr.diginamic.paie.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * Classe représentant les périodes dans la base de donnée. colonnnes de la bdd:
 * ID DATE_DEBUT DATE_FIN
 * 
 * en pratique dans la bdd les périodes sont celles de chaque mois de l'année
 * (avec une dateDebut au 1er du mois et uune dateFin au 30 ou 31 du mois)
 * 
 * @author Diginamic02
 *
 */
@Entity
public class Periode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dateDebut;
	private LocalDate dateFin;

	/**
	 * Constructeur
	 * 
	 */
	public Periode() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param dateDebut
	 * @param dateFin
	 */
	public Periode(LocalDate dateDebut, LocalDate dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
