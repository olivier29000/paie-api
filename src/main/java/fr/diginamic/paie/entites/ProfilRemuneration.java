package fr.diginamic.paie.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 
 * Classe représentant les profils de rémunartion dans la base de donnée.
 * colonnnes de la bdd: ID CODE
 * 
 * Le profil de rémunération permet de retrouver la liste des cotisations d'un
 * employé grâce à la table de jointure PROFIL_REMUNERATION_COTISATION qui liste
 * les id des cotisations en fonction de l'id du profil de rémurations
 * 
 * @author Diginamic02
 *
 */
@Entity
public class ProfilRemuneration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;

	@ManyToMany
	@JoinTable(name = "profil_remuneration_cotisation", joinColumns = @JoinColumn(name = "profil_remuneration_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "cotisation_id", referencedColumnName = "id"))
	private List<Cotisation> cotisations;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisations() {
		return cotisations;
	}

	public void setCotisations(List<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}

}
