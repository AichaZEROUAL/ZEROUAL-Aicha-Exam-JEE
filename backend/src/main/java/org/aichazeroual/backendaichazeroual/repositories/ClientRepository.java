package org.aichazeroual.backendaichazeroual.repositories;

import org.aichazeroual.backendaichazeroual.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
