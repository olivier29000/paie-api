package fr.diginamic.paie.entites;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Classe représentant un bulletin de salaire dans la base de donnée colonnnes
 * de la bdd: ID PRIME_EXCEPTIONNELLE PERIODE_ID REMUNERATION_EMPLOYE_ID
 * 
 * @author Diginamic02
 *
 */
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
	private String code;

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
		this.code = UUID.randomUUID().toString();
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
