package com.bananes.export.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Data
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "fk_destinataire", nullable = false)
    private Destinataire destinataire;
    @Column
    private LocalDate dateLivraison;
    @Column
    private int quantite;
    @Column
    private double prix;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return id == commande.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
