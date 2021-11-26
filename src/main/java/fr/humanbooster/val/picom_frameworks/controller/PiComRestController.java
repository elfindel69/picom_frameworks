package fr.humanbooster.val.picom_frameworks.controller;

import fr.humanbooster.val.picom_frameworks.business.Annonce;
import fr.humanbooster.val.picom_frameworks.business.Arret;
import fr.humanbooster.val.picom_frameworks.business.Client;
import fr.humanbooster.val.picom_frameworks.business.LoginForm;
import fr.humanbooster.val.picom_frameworks.service.AnnonceService;
import fr.humanbooster.val.picom_frameworks.service.ArretService;
import fr.humanbooster.val.picom_frameworks.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PiComRestController {

    private final AnnonceService annonceService;
    private final ArretService arretService;
    private final UtilisateurService utilisateurService;

    public PiComRestController(AnnonceService annonceService, ArretService arretService, UtilisateurService utilisateurService){
        this.annonceService = annonceService;
        this.arretService = arretService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/clients/email/{email}")
    String getPasswordByEmail(@PathVariable String email){
        return utilisateurService.getPasswordByEmail(email);
    }


    @GetMapping("/clients/{email}")
    Client getClientByEmail(@PathVariable String email){
        return utilisateurService.getClientByEmail(email);
    }

    @PostMapping("/clients/login")
    boolean getPasswordByEmail(@RequestBody LoginForm loginForm){
        System.out.println(loginForm);
        return utilisateurService.checkEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
    }

    @GetMapping("annonces/{email}")
    List<Annonce> getAnnonces(@PathVariable String email){
        Client client = utilisateurService.getClientByEmail(email);
        System.out.println(client);
        List<Annonce> res =  annonceService.recupererAnnonces(client);
        System.out.println(res);
        return res;
    }

    @GetMapping("annonces/{id}/prix")
    float getPrixAnnonce(@PathVariable Long id){
        Annonce annonce = annonceService.recupererAnnonce(id);

        return annonceService.calculerPrixAnnonce(annonce);
    }

    @GetMapping("annonce/arret/{id}")
    List<Annonce> recupererAnnoncesParArret(@PathVariable Long id){
        Arret arret = arretService.recupererArret(id);

        return annonceService.recupererAnnoncesParArret(arret);
    }

    @GetMapping("/clients/{id}/annonces")
    List<Annonce> recupererAnnoncesParIdClient(@PathVariable Long id){
        Client client = utilisateurService.recupererClientParId(id);
       return annonceService.recupererAnnonces(client);
    }

    @DeleteMapping("annonces/{id}")
    boolean deleteAnnonce(@PathVariable Long id){
       return annonceService.supprimerAnnonce(id);
    }


}
