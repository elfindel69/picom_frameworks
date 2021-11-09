package fr.humanbooster.val.picom_frameworks.business;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "administrateur")
@Entity
public class Administrateur extends Utilisateur {
    public Administrateur(String nom, String prenom, String email, String password) {
        super(nom,prenom,email,password);
    }

    public Administrateur() {

    }
}