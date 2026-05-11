package org.aichazeroual.backendaichazeroual.services;

import org.aichazeroual.backendaichazeroual.dtos.*;
import java.util.List;

public interface InsuranceService {
    // Gestion des Clients
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> listClients();
    ClientDTO getClient(Long clientId);

    // Gestion des Contrats
    ContratAutoDTO saveContratAuto(ContratAutoDTO contratAutoDTO, Long clientId);
    ContratSanteDTO saveContratSante(ContratSanteDTO contratSanteDTO, Long clientId);
    ContratHabitationDTO saveContratHabitation(ContratHabitationDTO habitationDTO, Long clientId);

    List<ContratAssuranceDTO> getContratsByClient(Long clientId);
    ContratAssuranceDTO getContrat(Long contratId);

    // Gestion des Paiements
    PaiementDTO savePaiement(PaiementDTO paiementDTO, Long contratId);
    List<PaiementDTO> getPaiementsByContrat(Long contratId);
}