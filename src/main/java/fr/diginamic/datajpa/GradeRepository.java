package fr.diginamic.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.paie.entites.Grade;

public interface GradeRepository extends JpaRepository<Grade, String> {

}
