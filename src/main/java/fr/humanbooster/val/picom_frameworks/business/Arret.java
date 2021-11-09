package fr.humanbooster.val.picom_frameworks.business;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Arret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Merci de rentrer un nom d'arrêt")
    private String nom;

    @Column(name = "adresse_ip")
    @NotBlank(message = "Merci de rentrer une adresse IP")
    private String adresseIP;

    @NotBlank(message = "Merci de rentrer un adresse GPS")
    private String gps;

    @JsonIgnore
    @ManyToOne
    @NotNull(message =  "l'arrêt doit appartenir à une zone")
    private Zone zone;

    public Arret() {
    }

    public Arret(String nom, Zone zone) {
        this.nom = nom;
        this.zone = zone;
        zone.getArrets().add(this);
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getAdresseIP() {
        return adresseIP;
    }

    public void setAdresseIP(String adresseIP) {
        this.adresseIP = adresseIP;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}