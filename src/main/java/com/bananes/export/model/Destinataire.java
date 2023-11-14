package com.bananes.export.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Destinataire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false)
    private int codePostal;
    @Column(nullable = false)
    private String ville;
    @Column(nullable = false)
    private String pays;
}
