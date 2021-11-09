package fr.humanbooster.val.picom_frameworks.dao;

import fr.humanbooster.val.picom_frameworks.business.Annonce;
import fr.humanbooster.val.picom_frameworks.business.Arret;
import fr.humanbooster.val.picom_frameworks.business.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(path = "annonces")
public interface AnnonceDao extends JpaRepository<Annonce, Long> {
    // Requête par dérivation
    List<Annonce> findByClient(Client client);

    List<Annonce> findByClientAndDateDeDebutBetween(Client client, Date dateDebut, Date dateFin);


    Page<Annonce> findByClient(Pageable pageable, Client client);

    @Query("SELECT an FROM Annonce an, Zone, Arret a WHERE a=:arret AND current_date >= an.dateDeDebut AND current_date <= an.dateDeFin")
    List<Annonce> findAnnoncesByArret(Arret arret);
}