package fr.humanbooster.val.picom_frameworks.business;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "prenom", nullable = false)
    @NotBlank(message = "Merci de rentrer un prénom")
    protected String prenom;

    @Column(name = "nom", nullable = false)
    @NotBlank(message = "Merci de rentrer un nom")
    protected String nom;

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "merci de renseigner un email valide")
    @NotBlank(message = "Merci de rentrer un email")
    protected String email;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Merci de rentrer un mot de passe")
    @Size(min=8, message = "Merci de rentrer un mot de passe d'au moins 8 caractères")
    protected String password;

    @Column(name = "date_inscription")
    protected Date dateInscription = new Date();

    public Utilisateur(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Utilisateur() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}