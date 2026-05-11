package org.aichazeroual.backendaichazeroual.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aichazeroual.backendaichazeroual.enums.TypeLogement;

@Entity @DiscriminatorValue("HAB")
@Data @NoArgsConstructor @AllArgsConstructor

public class ContratHabitation extends ContratAssurance {
    @Enumerated(EnumType.STRING)
    private TypeLogement typeLogement;
    private String adresse;
    private double superficie;
}
