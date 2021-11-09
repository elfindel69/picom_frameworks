package fr.humanbooster.val.picom_frameworks.business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "client")
@Entity
public class Client extends Utilisateur {

    @Column(name = "telephone")
    @NotBlank(message = "Merci de rentrer un téléphone")
    private String telephone;

    @JsonIgnore
    @OneToMany(mappedBy = "client",orphanRemoval = true)
    private List<Annonce> annonces;

    @OneToMany(mappedBy = "client",orphanRemoval = true)
    private List<CarteBancaire> carteBancaires;



    public Client() {
    }

    public Client(String nom, String prenom, String email, String password, String telephone) {
        super(nom,prenom,email,password);
        this.telephone = telephone;

    }

    public List<CarteBancaire> getCarteBancaires() {
        return carteBancaires;
    }

    public void setCarteBancaires(List<CarteBancaire> carteBancaires) {
        this.carteBancaires = carteBancaires;
    }
    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}