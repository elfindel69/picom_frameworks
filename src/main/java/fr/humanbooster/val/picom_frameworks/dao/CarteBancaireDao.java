package fr.humanbooster.val.picom_frameworks.dao;

import fr.humanbooster.val.picom_frameworks.business.CarteBancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cartesBancaires")
public interface CarteBancaireDao extends JpaRepository<CarteBancaire, Long> {
}