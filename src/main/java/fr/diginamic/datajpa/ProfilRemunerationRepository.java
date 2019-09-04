package fr.diginamic.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.paie.entites.ProfilRemuneration;

/**
 * Interface permettant des requetes sur la table PROFIL_REMUNERATION de la bdd
 * 
 * @author Diginamic02
 *
 */
public interface ProfilRemunerationRepository extends JpaRepository<ProfilRemuneration, String> {

	ProfilRemuneration findById(int id);

	ProfilRemuneration findByCode(String code);
}
