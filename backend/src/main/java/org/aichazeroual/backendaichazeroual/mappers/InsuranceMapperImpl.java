package org.aichazeroual.backendaichazeroual.mappers;

import org.aichazeroual.backendaichazeroual.dtos.*;
import org.aichazeroual.backendaichazeroual.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class InsuranceMapperImpl {

    public ClientDTO fromClient(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    public Client fromClientDTO(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }

    public ContratAutoDTO fromContratAuto(ContratAuto contratAuto) {
        ContratAutoDTO dto = new ContratAutoDTO();
        BeanUtils.copyProperties(contratAuto, dto);
        dto.setType("AUTO");
        return dto;
    }

    public ContratSanteDTO fromContratSante(ContratSante contratSante) {
        ContratSanteDTO dto = new ContratSanteDTO();
        BeanUtils.copyProperties(contratSante, dto);
        dto.setType("SANTE");
        return dto;
    }

    public ContratHabitationDTO fromContratHabitation(ContratHabitation contratHabitation) {
        ContratHabitationDTO dto = new ContratHabitationDTO();
        BeanUtils.copyProperties(contratHabitation, dto);
        dto.setType("HABITATION");
        return dto;
    }

    public ContratAuto fromContratAutoDTO(ContratAutoDTO dto) {
        ContratAuto contrat = new ContratAuto();
        BeanUtils.copyProperties(dto, contrat);
        return contrat;
    }

    public ContratSante fromContratSanteDTO(ContratSanteDTO dto) {
        ContratSante contrat = new ContratSante();
        BeanUtils.copyProperties(dto, contrat);
        return contrat;
    }


    public PaiementDTO fromPaiement(Paiement paiement) {
        PaiementDTO dto = new PaiementDTO();
        BeanUtils.copyProperties(paiement, dto);
        if (paiement.getContrat() != null) {
            dto.setContratId(paiement.getContrat().getId());
        }
        return dto;
    }

    public Paiement fromPaiementDTO(PaiementDTO dto) {
        Paiement paiement = new Paiement();
        BeanUtils.copyProperties(dto, paiement);
        return paiement;
    }
}