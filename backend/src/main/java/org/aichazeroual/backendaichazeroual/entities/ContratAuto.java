package org.aichazeroual.backendaichazeroual.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aichazeroual.backendaichazeroual.enums.TypeLogement;

@Entity @DiscriminatorValue("AUTO")
@Data @NoArgsConstructor @AllArgsConstructor

public class ContratAuto extends ContratAssurance {
    private String numImmatriculation;
    private String marque;
    private String modele;
}