package fr.humanbooster.val.picom_frameworks.service;

import fr.humanbooster.val.picom_frameworks.business.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AnnonceService {
    List<Annonce> recupererAnnonces(Client client);

    AnnonceImage enregistrerAnnonceImage(AnnonceImage annonceImage);

    AnnonceHtml enregistrerAnnonceHtml(AnnonceHtml annonceHtml);

    Annonce recupererAnnonce(Long id);

    Page<Annonce> recupererAnnonces(Pageable pageable, Client client);

    boolean supprimerAnnonce(Long id);

    float calculerPrixAnnonce(Annonce annonce);

    List<Annonce> recupererAnnoncesParArret(Arret arret);
}
