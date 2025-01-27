package repositories;

import entities.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservasRepositorio extends JpaRepository<Reservas, Long> {
    List<Reservas> findByUsuarioId(Long usuarioId);
}