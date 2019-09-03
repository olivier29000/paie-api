package fr.diginamic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.PeriodeVue;
import fr.diginamic.datajpa.PeriodeRepository;
import fr.diginamic.paie.entites.Periode;

@Service
public class PeriodeService {

	@Autowired
	private PeriodeRepository periodeRepository;

	public List<PeriodeVue> afficherPeriodes() {
		// TODO Auto-generated method stub

		List<Periode> listeDesPeriodes = periodeRepository.findAll();
		List<PeriodeVue> listeDesPeriodesVue = new ArrayList<PeriodeVue>();
		for (Periode periode : listeDesPeriodes) {
			listeDesPeriodesVue.add(new PeriodeVue(periode.getDateDebut(), periode.getDateFin()));
		}

		return listeDesPeriodesVue;
	}

	public Periode retrouverPeriodeEnFonctionId(Integer id) {

		return periodeRepository.findById(id);
	}

}
