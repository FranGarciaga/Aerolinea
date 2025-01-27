package mappers;

import dtos.ReservasRequest;
import entities.Reservas;
import entities.Usuarios;
import entities.Vuelos;
import org.springframework.stereotype.Service;

@Service
public class ReservasMapper {

    public ReservasRequest reservasToReservasRequest(Reservas reservas) {
        if (reservas == null) {
            return null;
        }

        ReservasRequest reservasRequest = new ReservasRequest();
        reservasRequest.setId(reservas.getId());
        reservasRequest.setUsuariosId(reservas.getUsuario().getId());
        reservasRequest.setVuelosId(reservas.getVuelo().getId());
        reservasRequest.setFechaReserva(reservas.getFechaReserva());

        return reservasRequest;
    }

    public Reservas reservasRequestToReservas(ReservasRequest reservasRequest) {
        if (reservasRequest == null) {
            return null;
        }

        Reservas reservas = new Reservas();
        reservas.setId(reservasRequest.getId());
        reservas.setUsuario(new Usuarios(reservasRequest.getUsuariosId()));
        reservas.setVuelo(new Vuelos(reservasRequest.getVuelosId()));
        reservas.setFechaReserva(reservasRequest.getFechaReserva());

        return reservas;
    }
}
