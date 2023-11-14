package com.bananes.export.repository;

import com.bananes.export.model.Commande;
import com.bananes.export.model.Destinataire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CommandeRepository extends CrudRepository<Commande, Long> {

    @Query(" FROM Commande d WHERE d.destinataire.id =:idDestinataire")
    Iterable<Commande> findByDestinataire(long idDestinataire);
}
