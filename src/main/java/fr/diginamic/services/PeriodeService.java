package fr.diginamic.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.PeriodeVue;
import fr.diginamic.datajpa.PeriodeRepository;
import fr.diginamic.paie.entites.Periode;

/**
 * Ce service permet d'effectuer des requetes dans la table PERIODE de la bdd
 * 
 * @author Diginamic02
 *
 */
@Service
public class PeriodeService {

	@Autowired
	private PeriodeRepository periodeRepository;

	/**
	 * Cette methode retourne une liste d'objets PeriodeVue qu'elle construit à
	 * partir d'une liste d'objets Periode, eux même obtenus grâce à une requete
	 * sur la table PERIODE de la BDD
	 * 
	 * @return
	 */
	public List<PeriodeVue> obtenirListeDePeriodesVue() {
		// TODO Auto-generated method stub

		List<Periode> listeDesPeriodes = periodeRepository.findAll();
		List<PeriodeVue> listeDesPeriodesVue = new ArrayList<PeriodeVue>();
		for (Periode periode : listeDesPeriodes) {
			listeDesPeriodesVue.add(new PeriodeVue(periode.getDateDebut(), periode.getDateFin()));
		}

		return listeDesPeriodesVue;
	}

	/**
	 * Cette methode effectue une requete dans la table PERIODE de la BDD et
	 * retourne l'objet Periode dont l'id (en parametre) correspond
	 * 
	 * @param id
	 * @return
	 */
	public Periode retrouverPeriodeEnFonctionId(Integer id) {

		return periodeRepository.findById(id);
	}

}
