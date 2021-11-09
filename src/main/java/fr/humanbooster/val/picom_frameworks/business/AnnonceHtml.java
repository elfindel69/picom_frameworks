package fr.humanbooster.val.picom_frameworks.business;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@Entity
public class AnnonceHtml extends Annonce {
    @Lob
    private String contenu;

    public AnnonceHtml() {
    }

    @NotBlank(message = "merci de renseigner un contenu")
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}