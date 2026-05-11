package org.aichazeroual.backendaichazeroual.dtos;

import lombok.Data;
import org.aichazeroual.backendaichazeroual.enums.TypePaiement;

import java.util.Date;

@Data
public class PaiementDTO {
    private Long id; // [cite: 21]
    private Date date; // [cite: 21]
    private double montant; // [cite: 21]
    private TypePaiement type; // [cite: 21]
    private Long contratId;
}
