package fr.humanbooster.val.picom_frameworks.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.implementation.bind.annotation.DefaultCall;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Zone {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "la zone doit avoir un nom")
    private String nom;


    private Float multiplicateur;

    @OneToMany(mappedBy = "zone" ,fetch=FetchType.EAGER, orphanRemoval = true)
    private List<Arret> arrets;

    @JsonIgnore
    @ManyToMany(mappedBy = "zones",cascade = CascadeType.DETACH)
    private List<Annonce> annonces;

    public Zone() {
    }

    public Zone(String nom, Float multiplicateur) {
        this.nom = nom;
        this.multiplicateur = multiplicateur;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    public List<Arret> getArrets() {
        return arrets;
    }

    public void setArrets(List<Arret> arrets) {
        this.arrets = arrets;
    }


    public Zone(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getMultiplicateur() {
        return multiplicateur;
    }

    public void setMultiplicateur(Float mutliplicateur) {
        this.multiplicateur = mutliplicateur;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", mutliplicateur=" + multiplicateur +
                '}';
    }
}
