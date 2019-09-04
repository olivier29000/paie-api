package fr.diginamic.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.paie.entites.Entreprise;

/**
 * Interface permettant des requetes sur la table ENTREPRISE de la bdd
 * 
 * @author Diginamic02
 *
 */
public interface EntrepriseRepository extends JpaRepository<Entreprise, String> {

	Entreprise findById(int id);

	Entreprise findByCode(String code);
}
