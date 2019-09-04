package fr.diginamic.controllers;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.services.BulletinDeSalaireReferentielsService;
import fr.diginamic.services.BulletinDeSalaireService;
import fr.diginamic.services.EntrepriseService;
import fr.diginamic.services.GradeService;
import fr.diginamic.services.PeriodeService;
import fr.diginamic.services.ProfilRemunerationService;
import fr.diginamic.services.RemunerationEmployeReferentielsService;
import fr.diginamic.services.RemunerationEmployeService;

/**
 * @author Diginamic02
 *
 */
@RestController
@RequestMapping(path = "/toto")
public class PaieApiController {

	@Autowired
	EntrepriseService entrepriseService;
	@Autowired
	GradeService gradeService;
	@Autowired
	ProfilRemunerationService profilRemunerationService;
	@Autowired
	RemunerationEmployeReferentielsService remunerationEmployeReferentielsService;
	@Autowired
	RemunerationEmployeService remunerationEmployeService;
	@Autowired
	BulletinDeSalaireReferentielsService bulletinDeSalaireReferentielsService;
	@Autowired
	PeriodeService periodeService;
	@Autowired
	BulletinDeSalaireService bulletinDeSalaireService;

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(PaieApiController.class);

}
