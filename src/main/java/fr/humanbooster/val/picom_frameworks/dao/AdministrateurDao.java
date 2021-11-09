package fr.humanbooster.val.picom_frameworks.dao;

import fr.humanbooster.val.picom_frameworks.business.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "administrateurs")
public interface AdministrateurDao extends JpaRepository<Administrateur,Long> {
}
