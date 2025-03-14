package org.example.repositories;

import org.example.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepositorio extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByUsername(String username);
}