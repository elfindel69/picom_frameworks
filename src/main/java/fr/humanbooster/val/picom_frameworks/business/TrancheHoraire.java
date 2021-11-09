package fr.humanbooster.val.picom_frameworks.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;

@Entity
public class TrancheHoraire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "heure_debut")
    @NotNull(message = "merci de renter une heure de début")
    private LocalTime heureDebut;

    @Column(name = "heure_fin")
    @NotNull(message = "merci de renter une heure de fin")
    private LocalTime heureFin;

    @NotNull(message = "merci de renter un prix")
    private Float prix;

    @JsonIgnore
    @ManyToMany(mappedBy = "trancheHoraires")
    private List<Annonce> annonces;

    public TrancheHoraire() {
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }


    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public List<Annonce> getZones() {
        return annonces;
    }

    public void setZones(List<Annonce> annonces) {
        this.annonces = annonces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}