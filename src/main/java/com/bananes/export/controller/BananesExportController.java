package com.bananes.export.controller;

import com.bananes.export.Exception.BusinessException;
import com.bananes.export.model.Commande;
import com.bananes.export.model.Destinataire;
import com.bananes.export.service.BananesExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BananesExportController {
    @Autowired
    private BananesExportService bananesExportService;
    @GetMapping("/destinataires")
    public Iterable<Destinataire> getDestinataires() {
        return bananesExportService.getListDestinataire();
    }

    @PostMapping("/destinataire")
    public Destinataire saveDestinataires(@RequestBody Destinataire destinataire)  {
            return bananesExportService.saveDestinataire(destinataire);
    }

    @DeleteMapping("/destinataire")
    public void deleteDestinataires(@RequestBody Destinataire destinataire) {
         bananesExportService.deleteDestinataire(destinataire);

    }

    @GetMapping("/commandes")
    public Iterable<Commande> getCommande(@RequestBody Destinataire destinataire) {
        return bananesExportService.getListCommandeByDesitnatiare(destinataire);
    }

    @PostMapping("/commandes")
    public Commande saveCommande(@RequestBody Commande commande) {
        return bananesExportService.saveCommande(commande);
    }

    @DeleteMapping("/commandes")
    public void deleteCommande(@RequestBody Commande commande) {
         bananesExportService.deleteCommande(commande);
    }

}
