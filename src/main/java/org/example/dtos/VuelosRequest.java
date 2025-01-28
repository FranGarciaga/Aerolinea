package org.example.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class VuelosRequest {
    @Setter
    private Long id;
    @Setter
    @Getter
    private String origen;
    private String destino;
    @Setter
    private LocalDateTime fecha;
    @Setter
    private int plazasDisponibles;
    @Setter
    private boolean disponible;

    public VuelosRequest() {}

    public VuelosRequest(Long id, String origen, String destino, LocalDateTime fecha, int plazasDisponibles, boolean disponible) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.plazasDisponibles = plazasDisponibles;
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public boolean isDisponible() {
        return disponible;
    }

}
