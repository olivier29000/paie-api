package fr.diginamic.paie.entites;

import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 
 * Classe représentant les rémunerationsEmployés dans la base de donnée.
 * colonnnes de la bdd: ID DATE_HEURE_DE_CREATION MATRICULE ENTREPRISE_ID
 * GRADE_ID PROFIL_REMUNERATION_ID
 * 
 * En pratique c'est l'utilisateur qui remplit les lignes de cette bdd grâce à
 * la méthode POST de l'url "/remuneration_employe" et une requete POST Http
 * avec un corps contenant un objet RemunerationEmployeCorpsPost IMPORTANT: Pour
 * insérer un bulletin de salaire dans la bdd il faut avoir créé une
 * rémuneration employé dans la bdd avec le même matricule que le bulletin de
 * salaire inséré
 * 
 * @author Diginamic02
 *
 */
@Entity
public class RemunerationEmploye {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String matricule;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Entreprise entreprise;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private ProfilRemuneration profilRemuneration;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Grade grade;

	private ZonedDateTime dateHeureDeCreation;

	/**
	 * Constructeur
	 * 
	 */
	public RemunerationEmploye() {
		super();
	}

	/**
	 * Constructeur
	 * 
	 * @param matricule
	 * @param entreprise
	 * @param profilRemuneration
	 * @param grade
	 */
	public RemunerationEmploye(String matricule, Entreprise entreprise, ProfilRemuneration profilRemuneration,
			Grade grade) {
		super();
		this.matricule = matricule;
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}

	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
}
