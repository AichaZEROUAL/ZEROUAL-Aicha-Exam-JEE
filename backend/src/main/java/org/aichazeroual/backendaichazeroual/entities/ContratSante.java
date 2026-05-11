package org.aichazeroual.backendaichazeroual.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aichazeroual.backendaichazeroual.enums.NiveauCouverture;

@Entity @DiscriminatorValue("SAN")
@Data @NoArgsConstructor @AllArgsConstructor

public class ContratSante extends ContratAssurance {
    @Enumerated(EnumType.STRING)
    private NiveauCouverture niveauCouverture;
    private int nbPersonnesCouvertes;
}
