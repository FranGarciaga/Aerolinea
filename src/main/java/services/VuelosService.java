package services;

import entities.Vuelos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.VuelosRepositorio;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VuelosService {

    @Autowired
    private VuelosRepositorio vuelosRepositorio;

    public List<Vuelos> buscarVuelos(String origen, String destino, LocalDateTime fecha) {
        return vuelosRepositorio.findByOrigenAndDestinoAndFechaAfter(origen, destino, fecha);
    }

    public Vuelos actualizarVuelo(Vuelos vuelo) {
        return vuelosRepositorio.save(vuelo);
    }

    public Vuelos buscarPorId(Long id) {
        return vuelosRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
    }
}
