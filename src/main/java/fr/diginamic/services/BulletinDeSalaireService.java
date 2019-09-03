package fr.diginamic.services;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.BulletinDeSalaireVue;
import fr.diginamic.datajpa.BulletinDeSalaireRepository;
import fr.diginamic.datajpa.RemunerationEmployeRepository;
import fr.diginamic.paie.entites.BulletinSalaire;

@Service
public class BulletinDeSalaireService {

	@Autowired
	BulletinDeSalaireRepository bulletinDeSalaireRepository;
	@Autowired
	RemunerationEmployeRepository remunerationEmployeRepository;

	public String ajouterBulletinDeSalaireEnBaseDeDonnee(BulletinSalaire bulletinSalaire) {

		bulletinDeSalaireRepository.save(bulletinSalaire);
		return "ok";

	}

	public List<BulletinDeSalaireVue> obtenirListeBulletinDeSalaire() {
		// TODO Auto-generated method stub
		List<BulletinSalaire> listeDeBulletinsDeSalaire = bulletinDeSalaireRepository.findAll();
		List<BulletinDeSalaireVue> listeDeBulletinsDeSalaireVue = new ArrayList<BulletinDeSalaireVue>();

		for (BulletinSalaire bulletinDeSalaire : listeDeBulletinsDeSalaire) {
			if (bulletinDeSalaire != null) {
				Integer id = bulletinDeSalaire.getRemunerationEmploye().getId();
				String matricule = remunerationEmployeRepository.findById(id).getMatricule();
				// remunerationEmployeRepository.findById(bulletinDeSalaire.getRemunerationEmploye().getId());
				listeDeBulletinsDeSalaireVue.add(new BulletinDeSalaireVue(ZonedDateTime.now(),
						bulletinDeSalaire.getPeriode(), matricule, 1.0, 1.0, 1.0));
			}

		}
		return listeDeBulletinsDeSalaireVue;
	}

}
