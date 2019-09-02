package fr.diginamic.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.paie.entites.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, String> {

	// Entreprise findByMatricule(String matricule);
	//
	// List<Entreprise> findByNom(String nom);
}
