package org.example.repositories;

import org.example.entities.Vuelos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VuelosRepositorio extends JpaRepository<Vuelos, Long> {
    List<Vuelos> findByOrigenAndDestinoAndFechaAfter(String origen, String destino, LocalDateTime fecha);
}