package fr.humanbooster.val.picom_frameworks.dao;

import fr.humanbooster.val.picom_frameworks.business.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestResource(collectionResourceRel = "clients",path = "clients")
public interface ClientDao extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}