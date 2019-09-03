package fr.diginamic.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.paie.entites.RemunerationEmploye;

public interface RemunerationEmployeRepository extends JpaRepository<RemunerationEmploye, String> {

	RemunerationEmploye findByMatricule(String matricule);

	RemunerationEmploye findById(Integer id);
}
