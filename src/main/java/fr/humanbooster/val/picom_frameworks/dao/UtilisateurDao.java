package fr.humanbooster.val.picom_frameworks.dao;

import fr.humanbooster.val.picom_frameworks.business.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "utilisateurs",path = "utilisateurs")
public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmailAndPassword(String email, String motDePasse);

    Page<Utilisateur> findByNomContaining(Pageable pageable, String nom);

    @Query("SELECT u.password FROM Utilisateur u WHERE u.email =:email ")
    String findPasswordByEmail(@Param("email") String email);
}