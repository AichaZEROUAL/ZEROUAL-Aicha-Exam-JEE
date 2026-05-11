package org.aichazeroual.backendaichazeroual.repositories;

import org.aichazeroual.backendaichazeroual.entities.ContratAssurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratRepository extends JpaRepository<ContratAssurance, Long> {
    List<ContratAssurance> findByClientId(Long clientId);
}
