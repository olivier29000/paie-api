package fr.diginamic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.BulletinDeSalaireReferentielsVue;
import fr.diginamic.Vues.PeriodeVue;
import fr.diginamic.Vues.RemunerationEmployeVue;

@Service
public class BulletinDeSalaireReferentielsService {

	@Autowired
	private PeriodeService periodeService;
	@Autowired
	private RemunerationEmployeService remunerationEmployeService;

	public BulletinDeSalaireReferentielsVue afficherReferentielsBulletinDeSalaire() {
		List<PeriodeVue> listeDePeriode = periodeService.afficherPeriodes();
		List<RemunerationEmployeVue> listeDeRemunerationEmployeVue = remunerationEmployeService
				.afficherRemunerationEmployeVue();
		List<String> listeDeMatricules = new ArrayList<String>();

		for (RemunerationEmployeVue remunerationEmployeVue : listeDeRemunerationEmployeVue) {
			listeDeMatricules.add(remunerationEmployeVue.getMatricule());
		}
		return new BulletinDeSalaireReferentielsVue(listeDePeriode, listeDeMatricules);
	}

}
