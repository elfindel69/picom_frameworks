package fr.humanbooster.val.picom_frameworks.service.impl;

import fr.humanbooster.val.picom_frameworks.business.TrancheHoraire;
import fr.humanbooster.val.picom_frameworks.dao.TrancheHoraireDao;
import fr.humanbooster.val.picom_frameworks.service.TrancheHoraireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrancheHoraireServiceImpl implements TrancheHoraireService {
    private final TrancheHoraireDao trancheHoraireDao;


    public TrancheHoraireServiceImpl(TrancheHoraireDao trancheHoraireDao) {
        this.trancheHoraireDao = trancheHoraireDao;
    }

    @Override
    public List<TrancheHoraire> recupererTranchesHoraires() {
        return trancheHoraireDao.findAll();
    }

    @Override
    public TrancheHoraire enregisterTrancheHoraire(TrancheHoraire trancheHoraire) {
        return trancheHoraireDao.save(trancheHoraire);
    }

    @Override
    public TrancheHoraire recupererTrancheHoraire(Long id) {
        return trancheHoraireDao.findById(id).orElse(null);
    }

    @Override
    public boolean supprimerTrancheHoraire(Long id) {
        if(recupererTrancheHoraire(id) != null){
            trancheHoraireDao.deleteById(id);
            return recupererTrancheHoraire(id) == null;
        }else{
            return false;
        }
    }
}
