package fr.diginamic.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.diginamic.paie.entites.Collegue;

@Service
public class ApiCollegueService {

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
}
