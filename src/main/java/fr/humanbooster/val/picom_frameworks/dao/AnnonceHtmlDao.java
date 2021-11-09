package fr.humanbooster.val.picom_frameworks.dao;

import fr.humanbooster.val.picom_frameworks.business.AnnonceHtml;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "annoncesHtml")
public interface AnnonceHtmlDao extends JpaRepository<AnnonceHtml, Long> {
}