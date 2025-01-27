package mappers;

import dtos.VuelosRequest;
import entities.Vuelos;
import org.springframework.stereotype.Service;

@Service
public class VuelosMapper {

    public VuelosRequest vueloToVueloRequest(Vuelos vuelos) {
        if (vuelos == null) {
            return null;
        }

        VuelosRequest vuelosRequest = new VuelosRequest();
        vuelosRequest.setId(vuelos.getId());
        vuelosRequest.setOrigen(vuelos.getOrigen());
        vuelosRequest.setDestino(vuelos.getDestino());
        vuelosRequest.setFecha(vuelos.getFecha());
        vuelosRequest.setPlazasDisponibles(vuelos.getPlazasDisponibles());
        vuelosRequest.setDisponible(vuelos.isDisponible());

        return vuelosRequest;
    }

    public Vuelos vueloRequestToVuelos(VuelosRequest vuelosRequest) {
        if (vuelosRequest == null) {
            return null;
        }

        Vuelos vuelos = new Vuelos();
        vuelos.setId(vuelosRequest.getId());
        vuelos.setOrigen(vuelosRequest.getOrigen());
        vuelos.setDestino(vuelosRequest.getDestino());
        vuelos.setFecha(vuelosRequest.getFecha());
        vuelos.setPlazasDisponibles(vuelosRequest.getPlazasDisponibles());
        vuelos.setDisponible(vuelosRequest.isDisponible());

        return vuelos;
    }
}
