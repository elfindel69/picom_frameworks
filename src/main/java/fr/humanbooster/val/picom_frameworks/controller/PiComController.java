package fr.humanbooster.val.picom_frameworks.controller;

import fr.humanbooster.val.picom_frameworks.business.Administrateur;
import fr.humanbooster.val.picom_frameworks.business.Arret;
import fr.humanbooster.val.picom_frameworks.business.Client;
import fr.humanbooster.val.picom_frameworks.business.Zone;
import fr.humanbooster.val.picom_frameworks.service.ArretService;
import fr.humanbooster.val.picom_frameworks.service.UtilisateurService;
import fr.humanbooster.val.picom_frameworks.service.ZoneService;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Random;

@Controller
public class PiComController {
    private final ZoneService zoneService;
    private final ArretService arretService;
    private final UtilisateurService utilisateurService;


    // Constructeur avec tous les objets que Spring doit injecter
    public PiComController(ZoneService zoneService, ArretService arretService, UtilisateurService utilisateurService) {
        super();
        this.zoneService = zoneService;
        this.arretService = arretService;
        this.utilisateurService = utilisateurService;
    }
    @PostConstruct // Spring invoquera cette méthode dès que le bean a été injécté
    private void init() {
        if (zoneService.recupererZones().isEmpty()) {
            for (int i = 1; i <= 100; i++) {
                zoneService.ajouterZone("Zone " + i,1.0f);
            }
        }

        if (arretService.recupererArrets().isEmpty()) {
            Arret arret = new Arret();
            arret.setNom("Place Gailleton");
            arret.setAdresseIP("10.0.0.2");
            arret.setGps("QR3J+FQ Lyon");
            arret = arretService.ajouterArret(arret, zoneService.recupererZone("Zone 1").getId());

            arretService.enregistrerArret(arret);
        }

        Zone zone = zoneService.recupererZone("Lyon 2");
        System.out.println(arretService.recupererArrets(zone));

        // on ajoute 100 clients et un admin si la table utilisateur est vide
        if (utilisateurService.compterNbUtilisateurs() == 0) {
            Random random = new Random();
            for (int i = 1; i <= 100; i++) {
                utilisateurService.enregistrerClient(new Client("nom" + random.nextInt(500),
                        "prenom" + random.nextInt(500), "email" + i + "@hb.com", "motDePasse" + i, "telephone" + i));
            }
            utilisateurService
                    .enregistrerAdministrateur(new Administrateur("nom", "prenom", "admin1@hb.com", "12345678"));
        }

    }
}
