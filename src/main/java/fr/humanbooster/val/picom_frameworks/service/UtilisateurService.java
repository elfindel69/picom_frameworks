package fr.humanbooster.val.picom_frameworks.service;

import fr.humanbooster.val.picom_frameworks.business.Administrateur;
import fr.humanbooster.val.picom_frameworks.business.Client;
import fr.humanbooster.val.picom_frameworks.business.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UtilisateurService {
     Client recupererClientParId(Long id);

    Client enregistrerClient(Client client);

    Administrateur enregistrerAdministrateur(Administrateur administrateur);

    Utilisateur recupererUtilisateur(String email, String motDePasse);

    Page<Utilisateur> recupererUtilisateurs(Pageable pageable);
    Page<Utilisateur> recupererUtilisateurs(Pageable pageable, String filtreNom);

    List<Utilisateur> recupererUtilisateurs();

    long compterNbUtilisateurs();

    String getPasswordByEmail(String email);

    boolean checkEmailAndPassword(String email, String password);

    Client getClientByEmail(String email);
}
