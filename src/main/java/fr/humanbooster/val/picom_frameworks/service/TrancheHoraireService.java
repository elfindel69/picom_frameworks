package fr.humanbooster.val.picom_frameworks.service;

import fr.humanbooster.val.picom_frameworks.business.TrancheHoraire;

import java.util.List;

public interface TrancheHoraireService {
    List<TrancheHoraire> recupererTranchesHoraires();

    TrancheHoraire enregisterTrancheHoraire(TrancheHoraire trancheHoraire);

    TrancheHoraire recupererTrancheHoraire(Long id);

    boolean supprimerTrancheHoraire(Long id);
}
