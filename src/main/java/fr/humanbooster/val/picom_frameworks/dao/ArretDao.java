package fr.humanbooster.val.picom_frameworks.dao;

import fr.humanbooster.val.picom_frameworks.business.Arret;
import fr.humanbooster.val.picom_frameworks.business.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "arrets")
public interface ArretDao extends JpaRepository<Arret, Long> {
    List<Arret> findByZone(Zone zone);

    List<Arret> findByNomContaining(String filtre);
}