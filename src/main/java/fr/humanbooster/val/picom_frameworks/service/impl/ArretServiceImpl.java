package fr.humanbooster.val.picom_frameworks.service.impl;


import fr.humanbooster.val.picom_frameworks.business.Arret;
import fr.humanbooster.val.picom_frameworks.business.Zone;
import fr.humanbooster.val.picom_frameworks.dao.ArretDao;
import fr.humanbooster.val.picom_frameworks.service.ArretService;
import fr.humanbooster.val.picom_frameworks.service.ZoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArretServiceImpl implements ArretService {

    private ArretDao arretDao;
    private ZoneService zoneService;

    public ArretServiceImpl(ArretDao arretDao, ZoneService zoneService) {
        super();
        this.arretDao = arretDao;
        this.zoneService = zoneService;
    }

    @Override
    public Arret ajouterArret(String nom, Long idZone) {
        Zone zone = zoneService.recupererZone(idZone);
        if (zone==null) {
            return null;
        }
        else {
            return arretDao.save(new Arret(nom, zone));
        }
    }

    @Override
    public List<Arret> recupererArrets() {
        return arretDao.findAll();
    }

    @Override
    public List<Arret> recupererArrets(Zone zone) {
        return arretDao.findByZone(zone);
    }

    @Override
    public Arret recupererArret(Long id) {
        return arretDao.findById(id).orElse(null);
    }

    @Override
    public boolean supprimerArret(Long id) {
        if(recupererArret(id) != null){
            arretDao.deleteById(id);
            return recupererArret(id) == null;
        }else{
            return false;
        }

    }

    @Override
    public Arret enregistrerArret(Arret arret) {
        return arretDao.save(arret);
    }

}

