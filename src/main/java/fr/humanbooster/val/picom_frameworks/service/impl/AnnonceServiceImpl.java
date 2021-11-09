package fr.humanbooster.val.picom_frameworks.service.impl;


import fr.humanbooster.val.picom_frameworks.business.*;
import fr.humanbooster.val.picom_frameworks.dao.AnnonceDao;
import fr.humanbooster.val.picom_frameworks.dao.AnnonceHtmlDao;
import fr.humanbooster.val.picom_frameworks.dao.AnnonceImageDao;
import fr.humanbooster.val.picom_frameworks.service.AnnonceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    private AnnonceDao annonceDao;
    private AnnonceImageDao annonceImageDao;
    private AnnonceHtmlDao annonceHtmlDao;

    public AnnonceServiceImpl(AnnonceDao annonceDao, AnnonceImageDao annonceImageDao, AnnonceHtmlDao annonceHtmlDao) {
        super();
        this.annonceDao = annonceDao;
        this.annonceImageDao = annonceImageDao;
        this.annonceHtmlDao = annonceHtmlDao;
    }

    @Override
    public List<Annonce> recupererAnnonces(Client client) {
        return annonceDao.findByClient(client);
    }

    @Override
    public AnnonceImage enregistrerAnnonceImage(AnnonceImage annonceImage) {
        return annonceImageDao.save(annonceImage);
    }

    @Override
    public AnnonceHtml enregistrerAnnonceHtml(AnnonceHtml annonceHtml) {
        return annonceHtmlDao.save(annonceHtml);
    }

    @Override
    public Annonce recupererAnnonce(Long id) {
        return annonceDao.findById(id).orElse(null);
    }

    @Override
    public Page<Annonce> recupererAnnonces(Pageable pageable, Client client) {
        return annonceDao.findByClient(pageable, client);
    }

    @Override
    public boolean supprimerAnnonce(Long id) {
        Annonce annonce = recupererAnnonce(id);
        if (annonce!=null) {
            annonceDao.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public float calculerPrixAnnonce(Annonce annonce) {
        float prix = .0f;
        for(Zone zone : annonce.getZones() ){
            for(TrancheHoraire th : annonce.getTrancheHoraires()){
                prix +=zone.getMutliplicateur()*th.getPrix();
            }
        }
        return prix;
    }

    @Override
    public List<Annonce> recupererAnnoncesParArret(Arret arret) {
        return annonceDao.findAnnoncesByArret(arret);
    }

}
