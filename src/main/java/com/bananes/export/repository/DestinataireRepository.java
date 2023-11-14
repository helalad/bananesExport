package com.bananes.export.repository;

import com.bananes.export.model.Destinataire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DestinataireRepository extends CrudRepository<Destinataire, Long> {


    Iterable<Destinataire> findByNomAndAdresseAndCodePostalAndVilleAndPays(String nom,String adresse,int codePostal,String ville,String pays);
}
