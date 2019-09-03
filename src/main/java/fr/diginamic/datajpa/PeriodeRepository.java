package fr.diginamic.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.paie.entites.Periode;

public interface PeriodeRepository extends JpaRepository<Periode, String> {

	Periode findById(Integer id);
}
