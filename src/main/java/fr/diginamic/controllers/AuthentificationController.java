package fr.diginamic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.services.ApiCollegueService;

@RestController
public class AuthentificationController {

	@Autowired
	ApiCollegueService apiCollegueService;

	@RequestMapping(path = "/authentification", method = RequestMethod.GET)
	public ResponseEntity<String> egrege() {

		return apiCollegueService.postAuthentification();

	}
}
