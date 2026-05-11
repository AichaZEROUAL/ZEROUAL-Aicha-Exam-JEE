package org.aichazeroual.backendaichazeroual.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aichazeroual.backendaichazeroual.enums.StatutContrat;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CONTRAT", length = 4)
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class ContratAssurance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateSouscription;
    @Enumerated(EnumType.STRING)
    private StatutContrat statut;
    private Date dateValidation;
    private double montantCotisation;
    private int duree;
    private double tauxCouverture;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "contrat")
    private List<Paiement> paiements;
}
