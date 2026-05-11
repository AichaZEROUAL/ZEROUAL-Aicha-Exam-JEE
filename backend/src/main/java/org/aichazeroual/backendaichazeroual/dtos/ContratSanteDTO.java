package org.aichazeroual.backendaichazeroual.dtos;

import lombok.Data;
import org.aichazeroual.backendaichazeroual.enums.NiveauCouverture;

@Data
public class ContratSanteDTO extends ContratAssuranceDTO {
    private NiveauCouverture niveauCouverture;
    private int nbPersonnesCouvertes;
}
