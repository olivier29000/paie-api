package fr.diginamic.paie.entites;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BulletinSalaire implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private RemunerationEmploye remunerationEmploye;

	@ManyToOne
	private Periode periode;
	private BigDecimal primeExceptionnelle;

	/**
	 * Constructeur
	 * 
	 */
	public BulletinSalaire() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param remunerationEmploye
	 * @param periode
	 * @param primeExceptionnelle
	 */
	public BulletinSalaire(RemunerationEmploye remunerationEmploye, Periode periode, BigDecimal primeExceptionnelle) {
		super();
		this.remunerationEmploye = remunerationEmploye;
		this.periode = periode;
		this.primeExceptionnelle = primeExceptionnelle;
	}

	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}

	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

	public Periode getPeriode() {
		return periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
