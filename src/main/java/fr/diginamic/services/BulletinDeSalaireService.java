package fr.diginamic.services;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.Vues.BulletinDeSalaireCompletVue;
import fr.diginamic.Vues.BulletinDeSalaireVue;
import fr.diginamic.datajpa.BulletinDeSalaireRepository;
import fr.diginamic.paie.entites.BulletinSalaire;
import fr.diginamic.paie.entites.Collegue;
import fr.diginamic.paie.entites.Cotisation;

/**
 * 
 * Ce Service permet d'effectuer des requetes sur la table bulletin de salaire
 * Elle est utile sur l'url "/bulletin_de_salaire" en POST et GET
 * 
 * @author Diginamic02
 *
 */
@Service
public class BulletinDeSalaireService {

	@Autowired
	BulletinDeSalaireRepository bulletinDeSalaireRepository;
	@Autowired
	ApiCollegueService apiCollegueService;

	/**
	 * Methode Cette methode permet d'ajouter dans la table BULLETIN_DE_SALAIRE
	 * une ligne grâce à un objet bulletinDeSalaire
	 * 
	 * @param bulletinSalaire
	 * @return
	 */
	public String ajouterBulletinDeSalaireEnBaseDeDonnee(BulletinSalaire bulletinSalaire) {

		bulletinDeSalaireRepository.save(bulletinSalaire);
		return "ok";

	}

	/**
	 * Cette Methode est utilisée lors de la visualisation par l'utilisateur
	 * d'un bulletin de salaire complet. page "bulletin de salaire", url:
	 * "/bulletin_de_salaire?code=XXXXXX" Elle est activée par un controleur lui
	 * même activé lorsque l'utilisateur appuie sur le bouton "visualiser" de la
	 * page "liste des bulletins de salaires" (url: "/bulletin_de_salaire"
	 * 
	 * Elle renvoie un objet BulletinDeSalaireCompletVue sous forme de JSON de
	 * cette forme:
	 * {"collegue":{"id":0,"matricule":"07163b61-190a-4db3-922c-ea01ed68da31","nom":"lasbleis","prenoms":"olivier","email":"lasb.oliv@yahoo.fr","dateDeNaissance":"2019-09-04","photoUrl":"http://ibgnews.com/wp-content/uploads/2016/07/Dev.jpg"},"bulletinSalaire":{"id":1,"remunerationEmploye":{"id":1,"matricule":"07163b61-190a-4db3-922c-ea01ed68da31","entreprise":{"id":2,"code":"SOP","siret":"5555555000022","denomination":"Sopra-Steria","adresse":null,"urssaf":null,"codeNaf":"6202A"},"profilRemuneration":{"id":1,"code":"Technicien","cotisations":[{"id":3,"code":"EP01","libelle":"URSSAF
	 * MALADIE - MATERNITE -
	 * INVALIDITE","tauxSalarial":0.01,"tauxPatronal":0.13,"imposable":false},{"id":4,"code":"EP02","libelle":"URSSAF
	 * SOLIDARITE","tauxSalarial":null,"tauxPatronal":0.00,"imposable":false},{"id":5,"code":"EP03","libelle":"URSSAF
	 * ACCIDENT DU
	 * TRAVAIL","tauxSalarial":null,"tauxPatronal":0.01,"imposable":false},{"id":6,"code":"EP04","libelle":"URSSAF
	 * ALLOC.
	 * FAMILIALES","tauxSalarial":null,"tauxPatronal":0.05,"imposable":false},{"id":7,"code":"EP05","libelle":"URSSAF
	 * ASS. VIEILLESSE
	 * PLAF.","tauxSalarial":0.07,"tauxPatronal":0.08,"imposable":false},{"id":8,"code":"EP06","libelle":"URSSAF
	 * ASS. VIEILLESSE
	 * DEPLAF.","tauxSalarial":0.00,"tauxPatronal":0.02,"imposable":false},{"id":9,"code":"EP07","libelle":"URSSAF
	 * FNAL","tauxSalarial":null,"tauxPatronal":0.00,"imposable":false},{"id":1,"code":"SP01","libelle":"URSSAF
	 * CSG NON
	 * DEDUCTIBLE","tauxSalarial":0.02,"tauxPatronal":null,"imposable":true},{"id":2,"code":"SP02","libelle":"URSSAF
	 * CRDS","tauxSalarial":0.01,"tauxPatronal":null,"imposable":true}]},"grade":{"id":2,"code":"GRADE_B","nbHeuresBase":152.00,"tauxBase":21.00},"dateHeureDeCreation":"2019-09-04T16:46:15.495+02:00"},"periode":{"id":1,"dateDebut":"2019-01-01","dateFin":"2019-01-31"},"primeExceptionnelle":1200.00},"primeExceptionnelle":1200.00}
	 * 
	 * @param code
	 * @return
	 */
	public BulletinDeSalaireCompletVue obtenirBulletinDeSalaireCompletVue(String code) {

		BulletinSalaire bulletinSalaire = bulletinDeSalaireRepository.findByCode(code);
		String matricule = bulletinSalaire.getRemunerationEmploye().getMatricule();
		Collegue collegue = apiCollegueService.obtenirCollegueEnFonctionDuMatricule(matricule);
		BigDecimal primeExceptionnelle = bulletinSalaire.getPrimeExceptionnelle();
		return new BulletinDeSalaireCompletVue(collegue, bulletinSalaire, primeExceptionnelle);

	}

	/**
	 * Methode
	 * 
	 * @return
	 */
	public List<BulletinDeSalaireVue> obtenirListeBulletinDeSalaireVues() {
		// TODO Auto-generated method stub
		List<BulletinSalaire> listeDeBulletinsDeSalaire = bulletinDeSalaireRepository.findAll();
		List<BulletinDeSalaireVue> listeDeBulletinsDeSalaireVue = new ArrayList<BulletinDeSalaireVue>();

		for (BulletinSalaire bulletinDeSalaire : listeDeBulletinsDeSalaire) {
			if (bulletinDeSalaire != null) {

				String matricule = bulletinDeSalaire.getRemunerationEmploye().getMatricule();

				BigDecimal nbHeuresBase = bulletinDeSalaire.getRemunerationEmploye().getGrade().getNbHeuresBase();

				BigDecimal tauxBase = bulletinDeSalaire.getRemunerationEmploye().getGrade().getTauxBase();

				BigDecimal salaireBrut = nbHeuresBase.multiply(tauxBase)
						.add(bulletinDeSalaire.getPrimeExceptionnelle());

				List<Cotisation> ListeDeCotisations = bulletinDeSalaire.getRemunerationEmploye().getProfilRemuneration()
						.getCotisations();

				BigDecimal salaireNetImposable = salaireBrut;

				for (Cotisation cotisation : ListeDeCotisations) {
					if (!cotisation.getImposable() && cotisation.getTauxSalarial() != null) {
						salaireNetImposable = salaireNetImposable
								.subtract(salaireBrut.multiply(cotisation.getTauxSalarial()));
					}
				}
				BigDecimal salaireNetAPayer = salaireNetImposable;
				for (Cotisation cotisation : ListeDeCotisations) {
					if (cotisation.getImposable() && cotisation.getTauxSalarial() != null) {
						salaireNetAPayer = salaireNetImposable
								.subtract(salaireBrut.multiply(cotisation.getTauxSalarial()));
					}
				}

				// remunerationEmployeRepository.findById(bulletinDeSalaire.getRemunerationEmploye().getId());
				listeDeBulletinsDeSalaireVue.add(new BulletinDeSalaireVue(ZonedDateTime.now(),
						bulletinDeSalaire.getPeriode(), matricule, salaireBrut, salaireNetImposable, salaireNetAPayer));
			}

		}
		return listeDeBulletinsDeSalaireVue;
	}

}
