package org.example.services;

import org.example.dtos.VuelosRequest;
import org.example.entities.Vuelos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repositories.VuelosRepositorio;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VuelosService {

    @Autowired
    private VuelosRepositorio vuelosRepositorio;

    public List<Vuelos> buscarVuelos(String origen, String destino, LocalDateTime fecha) {
        return vuelosRepositorio.findByOrigenAndDestinoAndFechaAfter(origen, destino, fecha);
    }

    public Vuelos actualizarVuelos(Vuelos vuelos) {
        return vuelosRepositorio.save(vuelos);
    }

    public Vuelos buscarPorId(Long id) {
        return vuelosRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
    }

    public void eliminarVuelo(Long id) {
    }

    public VuelosRequest actualizarVuelos(Long id, VuelosRequest vuelosRequest) {
        return vuelosRequest;
    }

    public VuelosRequest crearVuelos(VuelosRequest vuelosRequest) {
        return vuelosRequest;
    }

    public List<VuelosRequest> obtenerVuelos() {
        return List.of();
    }

    public VuelosRequest obtenerVuelo(Long id) {
        return null;
    }
}
