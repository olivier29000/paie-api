package fr.diginamic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.datajpa.RemunerationEmployeRepository;
import fr.diginamic.paie.entites.RemunerationEmploye;

@Service
public class RemunerationEmployeService {

	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;

	public void ajouterRemunerationEmployeEnBaseDeDonnee(RemunerationEmploye remunerationEmploye) {
		remunerationEmployeRepository.save(remunerationEmploye);
	}

}
