package fr.humanbooster.val.picom_frameworks.business;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

    protected String titre;

    @Lob
    protected String description;

    @Column(name = "date_de_debut")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date dateDeDebut;

    @Column(name = "date_de_fin")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "merci de renseigner une date dans le futur")
    protected Date dateDeFin;

    @Column(name = "date_de_creation")
    protected Date dateDeCreation = new Date();

    @ManyToMany
    protected List<Zone> zones;

    @ManyToMany
    protected List<TrancheHoraire> trancheHoraires;

    @ManyToOne
    protected Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Annonce() {
    }
    public void setTrancheHoraires(List<TrancheHoraire> trancheHoraires) {
        this.trancheHoraires = trancheHoraires;
    }

    public List<TrancheHoraire> getTrancheHoraires() {
        return trancheHoraires;
    }

    public List<Zone> getZones() {
        return zones;
    }
    public void setZones(List<Zone> zones) {
        this.zones = zones;
    }

    public Date getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(Date dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public Date getDateDeFin() {
        return dateDeFin;
    }

    public void setDateDeFin(Date dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    public Date getDateDeDebut() {
        return dateDeDebut;
    }

    public void setDateDeDebut(Date dateDeDebut) {
        this.dateDeDebut = dateDeDebut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
