package fr.humanbooster.val.picom_frameworks.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CarteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "numero_cb",length = 20)
    @NotBlank(message = "Merci de rentrer un numéro de CB")
    @CreditCardNumber(message = "Merci de rentrer un numéro de CB valide")
    private String numeroCB;

    @Column(name = "date_expiration", length = 5)
    @NotBlank(message = "Merci de rentrer une date d'expiration")
    private String dateExpiration;

    @Column(name = "code_cvv", length = 4)
    @NotBlank(message = "Merci de rentrer un code CVV")
    @Size(min = 3, max=4,message = "Merci de rentrer un code CVV valide" )
    private String codeCVV;

    @JsonIgnore
    @ManyToOne
    @NotNull(message = "merci de renseigner un client")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCodeCVV() {
        return codeCVV;
    }

    public void setCodeCVV(String codeCVV) {
        this.codeCVV = codeCVV;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getNumeroCB() {
        return numeroCB;
    }

    public void setNumeroCB(String numeroCB) {
        this.numeroCB = numeroCB;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}