package fr.diginamic.services;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.RemunerationEmployeVue;
import fr.diginamic.datajpa.RemunerationEmployeRepository;
import fr.diginamic.paie.entites.RemunerationEmploye;

@Service
public class RemunerationEmployeService {

	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	@Autowired
	private ApiCollegueService apiCollegueService;
	@Autowired
	private RemunerationEmployeService remunerationEmployeService;

	public String ajouterRemunerationEmployeEnBaseDeDonnee(RemunerationEmploye remunerationEmploye) {

		if (matriculeExisteDejaDansRemunerationEmploye(remunerationEmploye.getMatricule())) {
			return "{ \"message\" : \"le matricule est déjà présent dans la bdd Remuneration_Employe\" }";

		} else if (apiCollegueService.matriculeEmployeExisteChezApiCollegue(remunerationEmploye.getMatricule())) {
			remunerationEmploye.setDateHeureDeCreation(ZonedDateTime.now());
			remunerationEmployeRepository.save(remunerationEmploye);
			return "ok";
		} else {
			return "{ \"message\" : \"le matricule est absent de l'api collègue\" }";
		}

	}

	public List<RemunerationEmployeVue> afficherRemunerationEmployeVue() {
		// TODO Auto-generated method stub
		List<RemunerationEmploye> listeDesRemunerationEmploye = remunerationEmployeRepository.findAll();
		List<RemunerationEmployeVue> listeDesRemunerationEmployeVue = new ArrayList<RemunerationEmployeVue>();
		for (RemunerationEmploye remunerationEmploye : listeDesRemunerationEmploye) {
			listeDesRemunerationEmployeVue.add(new RemunerationEmployeVue(remunerationEmploye.getDateHeureDeCreation(),
					remunerationEmploye.getMatricule(), remunerationEmploye.getGrade().getCode()));
		}
		return listeDesRemunerationEmployeVue;
	}

	public boolean matriculeExisteDejaDansRemunerationEmploye(String matricule) {
		boolean resultat = false;
		List<RemunerationEmploye> listeDesRemunerationEmploye = remunerationEmployeRepository.findAll();
		for (RemunerationEmploye remunerationEmploye : listeDesRemunerationEmploye) {
			if (remunerationEmploye.getMatricule().equals(matricule)) {
				resultat = true;
			}
		}
		return resultat;

	}

	public RemunerationEmploye retrouverRemunerationEmployeEnfonctionMatricule(String matricule) {
		// TODO Auto-generated method stub
		return remunerationEmployeRepository.findByMatricule(matricule);
	}

}
