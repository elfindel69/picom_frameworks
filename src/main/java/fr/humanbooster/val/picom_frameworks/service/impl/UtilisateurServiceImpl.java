package fr.humanbooster.val.picom_frameworks.service.impl;

import fr.humanbooster.val.picom_frameworks.business.Administrateur;
import fr.humanbooster.val.picom_frameworks.business.Client;
import fr.humanbooster.val.picom_frameworks.business.Utilisateur;
import fr.humanbooster.val.picom_frameworks.dao.AdministrateurDao;
import fr.humanbooster.val.picom_frameworks.dao.ClientDao;
import fr.humanbooster.val.picom_frameworks.dao.UtilisateurDao;
import fr.humanbooster.val.picom_frameworks.service.UtilisateurService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final ClientDao clientDao;
    private final AdministrateurDao administrateurDao;
    private final UtilisateurDao utilisateurDao;

    public UtilisateurServiceImpl(ClientDao clientDao, AdministrateurDao administrateurDao,
                                  UtilisateurDao utilisateurDao) {
        super();
        this.clientDao = clientDao;
        this.administrateurDao = administrateurDao;
        this.utilisateurDao = utilisateurDao;
    }

    @Override
    public Client recupererClientParId(Long id) {
        return clientDao.findById(id).orElse(null);
    }

    @Override
    public Client enregistrerClient(Client client) {
        return clientDao.save(client);
    }

    @Override
    public Administrateur enregistrerAdministrateur(Administrateur administrateur) {
        return administrateurDao.save(administrateur);
    }

    @Override
    public Utilisateur recupererUtilisateur(String email, String motDePasse) {
        return utilisateurDao.findByEmailAndPassword(email, motDePasse);
    }

    @Override
    public Page<Utilisateur> recupererUtilisateurs(Pageable pageable) {
        return utilisateurDao.findAll(pageable);
    }

    @Override
    public Page<Utilisateur> recupererUtilisateurs(Pageable pageable, String filtreNom) {
        return utilisateurDao.findByNomContaining(pageable, filtreNom);
    }

    @Override
    public List<Utilisateur> recupererUtilisateurs() {
        return utilisateurDao.findAll();
    }

    @Override
    public long compterNbUtilisateurs() {
        return utilisateurDao.count();
    }

    @Override
    public String getPasswordByEmail(String email) {
        return utilisateurDao.findPasswordByEmail(email);
    }

    @Override
    public boolean checkEmailAndPassword(String email, String password) {
        String passwordBase = utilisateurDao.findPasswordByEmail(email);
        return passwordBase.equals(password);
    }
}

