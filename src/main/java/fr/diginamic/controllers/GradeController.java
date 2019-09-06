package fr.diginamic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.Vues.GradeVue;
import fr.diginamic.services.GradeService;

@RestController
@Secured("ROLE_ADMIN")
@RequestMapping(path = "/grades")
public class GradeController {
	@Autowired
	GradeService gradeService;

	/**
	 * /grades permet de visualiser sous la forme d'un JSON la liste des grades
	 * présents dans la base de donnée. Le JSON retourné est de la forme: [
	 * {"code":"GRADE_A","salaireAnnuel":1672.0000},
	 * {"code":"GRADE_B","salaireAnnuel":3192.0000},
	 * {"code":"GRADE_C","salaireAnnuel":4712.0000} ]
	 * 
	 * @return une liste d'instances de GradeVue
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<GradeVue> reqParamGrades() {

		return gradeService.obtenirListeGrades();
	}

}
