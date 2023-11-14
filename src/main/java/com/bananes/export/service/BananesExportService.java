package com.bananes.export.service;

import com.bananes.export.Exception.BusinessException;
import com.bananes.export.model.Commande;
import com.bananes.export.model.Destinataire;

public interface BananesExportService {
    Iterable<Destinataire> getListDestinataire();


    Iterable<Commande> getListCommandeByDesitnatiare(Destinataire destinataire);

    Destinataire saveDestinataire(Destinataire destinataire) throws BusinessException;

    void deleteDestinataire(Destinataire destinataire);

    Commande saveCommande(Commande commande);



    void deleteCommande(Commande commande);
}
