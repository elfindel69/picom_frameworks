package fr.humanbooster.val.picom_frameworks.service;

import fr.humanbooster.val.picom_frameworks.business.Zone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ZoneService {

    Zone ajouterZone(String nom, Float multiplicateur);

    Zone recupererZone(Long id);

    Zone recupererZone(String nom);

    List<Zone> recupererZones();

    Page<Zone> recupererZones(Pageable pageable);

    boolean supprimerZone(Long id);

    Zone enregistrerZone(Zone zone);

}
