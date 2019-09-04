package fr.diginamic.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.paie.entites.RemunerationEmploye;

/**
 * Interface permettant des requetes sur la table REMUNERATION_EMPLOYE de la bdd
 * 
 * @author Diginamic02
 *
 */
public interface RemunerationEmployeRepository extends JpaRepository<RemunerationEmploye, String> {

	RemunerationEmploye findByMatricule(String matricule);

	RemunerationEmploye findById(Integer id);
}
