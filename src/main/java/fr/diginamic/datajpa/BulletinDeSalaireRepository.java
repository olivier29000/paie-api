package fr.diginamic.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.paie.entites.BulletinSalaire;

public interface BulletinDeSalaireRepository extends JpaRepository<BulletinSalaire, String> {

}
