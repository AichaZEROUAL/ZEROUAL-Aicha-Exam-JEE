package org.aichazeroual.backendaichazeroual.services;

import lombok.AllArgsConstructor;
import org.aichazeroual.backendaichazeroual.dtos.*;
import org.aichazeroual.backendaichazeroual.entities.*;
import org.aichazeroual.backendaichazeroual.mappers.InsuranceMapperImpl;
import org.aichazeroual.backendaichazeroual.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
    private ClientRepository clientRepository;
    private ContratRepository contratRepository;
    private PaiementRepository paiementRepository;
    private InsuranceMapperImpl dtoMapper;

    // --- Gestion des Clients ---

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = dtoMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return dtoMapper.fromClient(savedClient);
    }

    @Override
    public List<ClientDTO> listClients() {
        return clientRepository.findAll().stream()
                .map(dtoMapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        return dtoMapper.fromClient(client);
    }

    // --- Gestion des Contrats ---

    @Override
    public ContratAutoDTO saveContratAuto(ContratAutoDTO dto, Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        ContratAuto contrat = dtoMapper.fromContratAutoDTO(dto);
        contrat.setClient(client);
        ContratAuto savedContrat = contratRepository.save(contrat);
        return dtoMapper.fromContratAuto(savedContrat);
    }

    @Override
    public ContratSanteDTO saveContratSante(ContratSanteDTO dto, Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        ContratSante contrat = dtoMapper.fromContratSanteDTO(dto);
        contrat.setClient(client);
        ContratSante savedContrat = contratRepository.save(contrat);
        return dtoMapper.fromContratSante(savedContrat);
    }

    @Override
    public ContratHabitationDTO saveContratHabitation(ContratHabitationDTO dto, Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        ContratHabitation contrat = new ContratHabitation(); // Mapping manuel ici car non généré
        org.springframework.beans.BeanUtils.copyProperties(dto, contrat);
        contrat.setClient(client);
        ContratHabitation savedContrat = contratRepository.save(contrat);
        return dtoMapper.fromContratHabitation(savedContrat);
    }

    @Override
    public List<ContratAssuranceDTO> getContratsByClient(Long clientId) {
        List<ContratAssurance> contrats = contratRepository.findByClientId(clientId);
        return contrats.stream().map(c -> {
            if (c instanceof ContratAuto) return dtoMapper.fromContratAuto((ContratAuto) c);
            if (c instanceof ContratSante) return dtoMapper.fromContratSante((ContratSante) c);
            return dtoMapper.fromContratHabitation((ContratHabitation) c);
        }).collect(Collectors.toList());
    }

    @Override
    public ContratAssuranceDTO getContrat(Long contratId) {
        ContratAssurance contrat = contratRepository.findById(contratId)
                .orElseThrow(() -> new RuntimeException("Contrat non trouvé"));
        if (contrat instanceof ContratAuto) return dtoMapper.fromContratAuto((ContratAuto) contrat);
        if (contrat instanceof ContratSante) return dtoMapper.fromContratSante((ContratSante) contrat);
        return dtoMapper.fromContratHabitation((ContratHabitation) contrat);
    }

    // --- Gestion des Paiements ---

    @Override
    public PaiementDTO savePaiement(PaiementDTO dto, Long contratId) {
        ContratAssurance contrat = contratRepository.findById(contratId)
                .orElseThrow(() -> new RuntimeException("Contrat non trouvé"));
        Paiement paiement = dtoMapper.fromPaiementDTO(dto);
        paiement.setContrat(contrat);
        Paiement savedPaiement = paiementRepository.save(paiement);
        return dtoMapper.fromPaiement(savedPaiement);
    }

    @Override
    public List<PaiementDTO> getPaiementsByContrat(Long contratId) {
        return paiementRepository.findByContratId(contratId).stream()
                .map(dtoMapper::fromPaiement)
                .collect(Collectors.toList());
    }
}