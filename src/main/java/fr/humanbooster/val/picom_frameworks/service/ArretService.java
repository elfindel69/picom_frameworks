package fr.humanbooster.val.picom_frameworks.service;

import fr.humanbooster.val.picom_frameworks.business.Arret;
import fr.humanbooster.val.picom_frameworks.business.Zone;

import java.util.List;

public interface ArretService {
    Arret ajouterArret(String nom, Long idZone);

    Arret enregistrerArret(Arret arret);

    List<Arret> recupererArrets();

    List<Arret> recupererArrets(Zone zone);

    Arret recupererArret(Long id);

    boolean supprimerArret(Long id);
}
