package fr.diginamic.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.diginamic.paie.entites.Collegue;

/**
 * 
 * Ce Service gère les liens de l'application avec l'api
 * https://olivier-collegues-api.herokuapp.com/collegues Par exemple, lors de
 * l'insertion d'une rémunerationEmploye dans la base de donnée, ce service est
 * utilisé pour vérifier que le matricule renseigné correspond bien à un
 * matricule (et donc un collegue) présent dans cette API
 * 
 * @author Diginamic02
 *
 */
@Service
public class ApiCollegueService {

	/**
	 * Methode Cette methode verifie si un matricule est présent dans l'api
	 * collegue Elle fait un appel dans l'api collegue et retourne une liste de
	 * collegue. Une boucle vérifie alors chaque collegue pour voir si son
	 * matricule correspond à celui an parametre de la methode. Un booleen qui
	 * correspond à la présence ou nom de ce matricule est retourné (TRUE =
	 * matricule présent). Cette methode sert principalement lors de l'insertion
	 * d'une rémunérationEmployé en bdd (url "/remuneration_employe" en POST)
	 * 
	 *
	 * @param matricule
	 * @return
	 */
	public boolean matriculeEmployeExisteChezApiCollegue(String matricule) {

		boolean resultat = false;
		RestTemplate rt = new RestTemplate();
		Collegue[] result = rt.getForObject("https://olivier-collegues-api.herokuapp.com/collegues", Collegue[].class);

		for (Collegue collegue : result) {
			if (collegue.getMatricule().equals(matricule)) {
				resultat = true;
			}
		}
		return resultat;
	}

	public Collegue obtenirCollegueEnFonctionDuMatricule(String matricule) {

		Collegue resultat = new Collegue();
		RestTemplate rt = new RestTemplate();
		Collegue[] result = rt.getForObject("https://olivier-collegues-api.herokuapp.com/collegues", Collegue[].class);

		for (Collegue collegue : result) {
			if (collegue.getMatricule().equals(matricule)) {
				resultat = collegue;
			}
		}
		return resultat;
	}
}
