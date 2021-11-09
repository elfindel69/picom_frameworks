package fr.humanbooster.val.picom_frameworks.controller;

import fr.humanbooster.val.picom_frameworks.business.Annonce;
import fr.humanbooster.val.picom_frameworks.business.Arret;
import fr.humanbooster.val.picom_frameworks.business.Client;
import fr.humanbooster.val.picom_frameworks.business.LoginForm;
import fr.humanbooster.val.picom_frameworks.service.AnnonceService;
import fr.humanbooster.val.picom_frameworks.service.ArretService;
import fr.humanbooster.val.picom_frameworks.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
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

    @CrossOrigin(origins = "*")
    @PostMapping("/clients/login")
    boolean getPasswordByEmail(@RequestBody LoginForm loginForm){
        System.out.println(loginForm);
        return utilisateurService.checkEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
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
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/clients/login").allowedOrigins("*");
            }
        };
    }
}
