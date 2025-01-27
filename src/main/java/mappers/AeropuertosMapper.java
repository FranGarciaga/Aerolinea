package mappers;

import dtos.AeropuertosRequest;
import entities.Aeropuertos;
import org.springframework.stereotype.Service;

@Service
public class AeropuertosMapper {

    public AeropuertosRequest aeropuertosToAeropuertosRequest(Aeropuertos aeropuertos) {
        if (aeropuertos == null) {
            return null;
        }

        AeropuertosRequest aeropuertosRequest = new AeropuertosRequest();
        aeropuertosRequest.setId(aeropuertos.getId());
        aeropuertosRequest.setNombre(aeropuertos.getNombre());
        aeropuertosRequest.setUbicacion(aeropuertos.getUbicacion());

        return aeropuertosRequest;
    }

    public Aeropuertos aeropuertoRequestToAeropuerto(AeropuertosRequest aeropuertosRequest) {
        if (aeropuertosRequest == null) {
            return null;
        }

        Aeropuertos aeropuertos = new Aeropuertos();
        aeropuertos.setId(aeropuertosRequest.getId());
        aeropuertos.setNombre(aeropuertosRequest.getNombre());
        aeropuertos.setUbicacion(aeropuertosRequest.getUbicacion());

        return aeropuertos;
    }
}
