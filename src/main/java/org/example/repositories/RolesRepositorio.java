package org.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.entities.Roles;

@Repository
public interface RolesRepositorio extends JpaRepository<Roles, Long> {
}
