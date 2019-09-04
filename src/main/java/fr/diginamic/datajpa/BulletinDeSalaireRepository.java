package fr.diginamic.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.paie.entites.BulletinSalaire;

/**
 * Interface permettant des requetes sur la table BULLETIN_SALAIRE de la bdd
 * 
 * @author Diginamic02
 *
 */
public interface BulletinDeSalaireRepository extends JpaRepository<BulletinSalaire, String> {

	BulletinSalaire findByCode(String code);
}
