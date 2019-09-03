package fr.diginamic.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.paie.entites.ProfilRemuneration;

public interface ProfilRemunerationRepository extends JpaRepository<ProfilRemuneration, String> {

	ProfilRemuneration findById(int id);

	ProfilRemuneration findByCode(String code);
}
