package fr.diginamic.paie.entites;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Diginamic02 Classe représentant un collegue de l'api
 *         https://olivier-collegues-api.herokuapp.com/collegues Dans cette
 *         application on va principalement vérifier si le matricule inséré est
 *         présent dans cette API Sinon l'insertion dans la bdd de paie-api est
 *         refusée
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Collegue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	public String matricule;
	public String nom;
	public String prenoms;
	public String email;
	public LocalDate dateDeNaissance;
	public String photoUrl;

	/**
	 * Constructeur
	 * 
	 * @param matricule
	 * @param nom
	 * @param prenoms
	 * @param email
	 * @param dateDeNaissance
	 * @param photoUrl
	 */
	public Collegue(String matricule, String nom, String prenoms, String email, LocalDate dateDeNaissance,
			String photoUrl) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenoms = prenoms;
		this.email = email;
		this.dateDeNaissance = dateDeNaissance;
		this.photoUrl = photoUrl;
	}

}
