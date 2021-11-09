package fr.humanbooster.val.picom_frameworks.dao;

import fr.humanbooster.val.picom_frameworks.business.TrancheHoraire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tranchesHoraires")
public interface TrancheHoraireDao extends JpaRepository<TrancheHoraire, Long> {
}