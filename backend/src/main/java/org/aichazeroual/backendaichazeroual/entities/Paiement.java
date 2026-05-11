package org.aichazeroual.backendaichazeroual.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aichazeroual.backendaichazeroual.enums.TypePaiement;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class Paiement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double montant;

    @Enumerated(EnumType.STRING)
    private TypePaiement type;

    @ManyToOne
    private ContratAssurance contrat;
}
