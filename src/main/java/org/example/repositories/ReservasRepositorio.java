package org.example.repositories;

import org.example.dtos.ReservasRequest;
import org.example.entities.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservasRepositorio extends JpaRepository<Reservas, Long> {
    List<ReservasRequest> findByUsuarioId(Long usuarioId);
}