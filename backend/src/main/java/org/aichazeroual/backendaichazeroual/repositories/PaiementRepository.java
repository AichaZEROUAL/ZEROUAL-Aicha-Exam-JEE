package org.aichazeroual.backendaichazeroual.repositories;

import org.aichazeroual.backendaichazeroual.entities.ContratAssurance;
import org.aichazeroual.backendaichazeroual.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
