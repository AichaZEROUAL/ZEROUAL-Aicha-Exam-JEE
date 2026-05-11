package org.aichazeroual.backendaichazeroual.dtos;

import lombok.Data;
import org.aichazeroual.backendaichazeroual.enums.StatutContrat;

import java.util.Date;

@Data
public class ContratAssuranceDTO {
    private Long id;
    private Date dateSouscription;
    private StatutContrat statut;
    private double montantCotisation;
    private int duree;
    private double tauxCouverture;
    private String type; // pour distinguer le type dans Angular
}
