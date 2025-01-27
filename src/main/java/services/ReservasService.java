package services;

import entities.Reservas;
import entities.Vuelos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ReservasRepositorio;
import repositories.VuelosRepositorio;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepositorio reservasRepositorio;

    @Autowired
    private VuelosRepositorio vuelosRepositorio;

    @Transactional
    public Reservas crearReserva(Reservas reserva) {
        Vuelos vuelo = vuelosRepositorio.findById(reserva.getVuelo().getId())
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        if (!vuelo.isDisponible() || vuelo.getPlazasDisponibles() < reserva.getCantidad()) {
            throw new RuntimeException("No hay plazas disponibles para este vuelo");
        }

        vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles() - reserva.getCantidad());
        vuelosRepositorio.save(vuelo);

        reserva.setFechaReserva(LocalDateTime.now());
        return reservasRepositorio.save(reserva);
    }

    public List<Reservas> obtenerReservasPorUsuario(Long usuarioId) {
        return reservasRepositorio.findByUsuarioId(usuarioId);
    }
}
