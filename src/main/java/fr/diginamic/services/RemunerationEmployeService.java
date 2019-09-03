package fr.diginamic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.datajpa.RemunerationEmployeRepository;
import fr.diginamic.paie.entites.RemunerationEmploye;

@Service
public class RemunerationEmployeService {

	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	@Autowired
	private ApiCollegueService apiCollegueService;

	public String ajouterRemunerationEmployeEnBaseDeDonnee(RemunerationEmploye remunerationEmploye) {

		if (apiCollegueService.matriculeEmployeExisteChezApiCollegue(remunerationEmploye.getMatricule())) {
			remunerationEmployeRepository.save(remunerationEmploye);
			return "ok";
		} else {
			return "{ \"message\" : \"le matricule est absent de l'api collègue\" }";
		}

	}

}
