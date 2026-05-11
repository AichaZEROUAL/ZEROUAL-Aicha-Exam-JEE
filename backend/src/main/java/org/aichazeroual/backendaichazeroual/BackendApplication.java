package org.aichazeroual.backendaichazeroual;

import org.aichazeroual.backendaichazeroual.entities.*;
import org.aichazeroual.backendaichazeroual.enums.NiveauCouverture;
import org.aichazeroual.backendaichazeroual.enums.StatutContrat;
import org.aichazeroual.backendaichazeroual.enums.TypeLogement;
import org.aichazeroual.backendaichazeroual.enums.TypePaiement;
import org.aichazeroual.backendaichazeroual.repositories.ClientRepository;
import org.aichazeroual.backendaichazeroual.repositories.ContratRepository;
import org.aichazeroual.backendaichazeroual.repositories.PaiementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository,
                            ContratRepository contratRepository,
                            PaiementRepository paiementRepository) {
        return args -> {
            // Création d'un Client
            Client client1 = Client.builder()
                    .nom("Aicha Zeroual")
                    .email("aicha.zer@enset.ma")
                    .build();
            clientRepository.save(client1);

            // Création d'un Contrat Automobile
            ContratAuto auto = new ContratAuto();
            auto.setDateSouscription(new Date());
            auto.setStatut(StatutContrat.EN_COURS);
            auto.setMontantCotisation(4500.0);
            auto.setClient(client1);
            auto.setNumImmatriculation("6-A-12345");
            auto.setMarque("Dacia");
            auto.setModele("Sandero");
            contratRepository.save((ContratAssurance) auto);

            // Création d'un Contrat Santé
            ContratSante sante = new ContratSante();
            sante.setDateSouscription(new Date());
            sante.setStatut(StatutContrat.VALIDE);
            sante.setMontantCotisation(2000.0);
            sante.setClient(client1);
            sante.setNiveauCouverture(NiveauCouverture.PREMIUM);
            sante.setNbPersonnesCouvertes(3);
            contratRepository.save((ContratAssurance) sante);

            // Création d'un Contrat Habitation
            ContratHabitation hab = new ContratHabitation();
            hab.setDateSouscription(new Date());
            hab.setStatut(StatutContrat.EN_COURS);
            hab.setMontantCotisation(3000.0);
            hab.setClient(client1);
            hab.setTypeLogement(TypeLogement.APPARTEMENT);
            hab.setAdresse("Mohammedia");
            hab.setSuperficie(80.5);
            contratRepository.save((ContratAssurance) hab);

            // Ajout d'un Paiement pour le contrat Auto
            Paiement p1 = Paiement.builder()
                    .date(new Date())
                    .montant(1500.0)
                    .type(TypePaiement.MENSUALITE)
                    .contrat(auto)
                    .build();
            paiementRepository.save(p1);
        };
    }
}
