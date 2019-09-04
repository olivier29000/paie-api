package fr.diginamic.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.paie.entites.Periode;

/**
 * Interface permettant des requetes sur la table PERIODE de la bdd
 * 
 * @author Diginamic02
 *
 */
public interface PeriodeRepository extends JpaRepository<Periode, String> {

	Periode findById(Integer id);
}
