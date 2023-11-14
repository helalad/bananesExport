package com.bananes.export.service.Impl;

import com.bananes.export.Exception.BusinessException;
import com.bananes.export.model.Commande;
import com.bananes.export.model.Destinataire;
import com.bananes.export.repository.CommandeRepository;
import com.bananes.export.repository.DestinataireRepository;
import com.bananes.export.service.BananesExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class BananesExportServiceImp implements BananesExportService {

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    DestinataireRepository destinataireRepository;

    @Override
    public Iterable<Destinataire> getListDestinataire() {
        return destinataireRepository.findAll();
    }


    @Override
    public Iterable<Commande> getListCommandeByDesitnatiare(Destinataire destinataire) {
        return commandeRepository.findByDestinataire(destinataire.getId());
    }

    @Override
    public Destinataire saveDestinataire(Destinataire destinataire) throws BusinessException {
        if (checkExistDestinataire(destinataire)) {
            throw new BusinessException("Destinataire deja créé !!");
        }
        return destinataireRepository.save(destinataire);
    }


    @Override
    public void deleteDestinataire(Destinataire destinataire) {
        destinataireRepository.delete(destinataire);
    }

    @Override
    public Commande saveCommande(Commande commande) {
        commande = checkInputcommande(commande);
        return commandeRepository.save(commande);
    }

    private Commande checkInputcommande(Commande commande) {
        if (commande == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        if (commande.getQuantite() < 0 || commande.getQuantite() > 10000 || commande.getQuantite() % 25 != 0)
            throw new BusinessException("Verifier la quantité de votre commande ! ");
        if (commande.getDateLivraison().isBefore(LocalDate.now().plusDays(7)))
        throw new BusinessException("La date de livraison doit être, au minimum, une semaine dans le futur par rapport à la date du jour! ");
        commande.setPrix(commande.getQuantite() * 2.5);
        return commande;
    }


    @Override
    public void deleteCommande(Commande commande) {
        commandeRepository.delete(commande);
    }

    private boolean checkExistDestinataire(Destinataire destinataire) {
        if (destinataire.getId() == 0) {
            return
                    destinataireRepository
                            .findByNomAndAdresseAndCodePostalAndVilleAndPays(destinataire.getNom(), destinataire.getAdresse(), destinataire.getCodePostal(), destinataire.getVille(), destinataire.getPays()).iterator().hasNext();
        }

        return false;
    }
}
