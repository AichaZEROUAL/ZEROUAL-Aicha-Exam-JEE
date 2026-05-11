package org.aichazeroual.backendaichazeroual.dtos;

import lombok.Data;
import org.aichazeroual.backendaichazeroual.enums.TypeLogement;

@Data
public class ContratHabitationDTO extends ContratAssuranceDTO {
    private TypeLogement typeLogement;
    private String adresse;
    private double superficie;
}
