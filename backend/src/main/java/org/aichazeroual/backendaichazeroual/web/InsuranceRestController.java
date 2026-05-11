package org.aichazeroual.backendaichazeroual.web;

import lombok.AllArgsConstructor;
import org.aichazeroual.backendaichazeroual.dtos.*;
import org.aichazeroual.backendaichazeroual.services.InsuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin("*")
public class InsuranceRestController {
    private InsuranceService insuranceService;

    // --- Gestion des Clients ---
    @GetMapping("/clients")
    public List<ClientDTO> clients() {
        return insuranceService.listClients();
    }

    @GetMapping("/clients/{id}")
    public ClientDTO getClient(@PathVariable(name = "id") Long clientId) {
        return insuranceService.getClient(clientId);
    }

    @PostMapping("/clients")
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return insuranceService.saveClient(clientDTO);
    }

    // --- Gestion des Contrats ---
    @GetMapping("/clients/{id}/contrats")
    public List<ContratAssuranceDTO> getContratsByClient(@PathVariable Long id) {
        return insuranceService.getContratsByClient(id);
    }

    @GetMapping("/contrats/{id}")
    public ContratAssuranceDTO getContrat(@PathVariable(name = "id") Long contratId) {
        return insuranceService.getContrat(contratId);
    }

    @PostMapping("/clients/{id}/contrats/auto")
    public ContratAutoDTO saveContratAuto(@RequestBody ContratAutoDTO dto, @PathVariable Long id) {
        return insuranceService.saveContratAuto(dto, id);
    }

    @PostMapping("/clients/{id}/contrats/sante")
    public ContratSanteDTO saveContratSante(@RequestBody ContratSanteDTO dto, @PathVariable Long id) {
        return insuranceService.saveContratSante(dto, id);
    }

    // --- Gestion des Paiements ---
    @PostMapping("/contrats/{id}/paiements")
    public PaiementDTO savePaiement(@RequestBody PaiementDTO paiementDTO, @PathVariable Long id) {
        return insuranceService.savePaiement(paiementDTO, id);
    }

    @GetMapping("/contrats/{id}/paiements")
    public List<PaiementDTO> getPaiements(@PathVariable Long id) {
        return insuranceService.getPaiementsByContrat(id);
    }
}