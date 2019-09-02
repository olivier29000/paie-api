package fr.diginamic.datajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.Vues.EntrepriseVue;
import fr.diginamic.paie.entites.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, String> {

	default List<EntrepriseVue> findAllEntrepriseVue() {

		return null;

	}
}
