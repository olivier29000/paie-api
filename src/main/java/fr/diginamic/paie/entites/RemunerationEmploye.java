package fr.diginamic.paie.entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RemunerationEmploye {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String matricule;

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

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Entreprise entreprise;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private ProfilRemuneration profilRemuneration;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Grade grade;

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
}
