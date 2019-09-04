package fr.diginamic.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.paie.entites.Grade;

/**
 * 
 * Interface permettant des requetes sur la table GRADE de la bdd
 * 
 * @author Diginamic02
 *
 */
public interface GradeRepository extends JpaRepository<Grade, String> {

	Grade findById(int id);

	Grade findByCode(String code);

}
