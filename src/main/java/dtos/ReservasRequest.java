package dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ReservasRequest {
    @Setter
    @Getter
    private Long id;
    @Setter
    @Getter
    private Long usuariosId;
    private Long vuelosId;
    private LocalDateTime fechaReserva;
    private String estadoReserva;  // "pendiente", "confirmada", "cancelada"

    public ReservasRequest() {}

    public ReservasRequest(Long id, Long usuariosId, Long vuelosId, LocalDateTime fechaReserva, String estadoReserva) {
        this.id = id;
        this.usuariosId = usuariosId;
        this.vuelosId = vuelosId;
        this.fechaReserva = fechaReserva;
        this.estadoReserva = estadoReserva;
    }

    public Long getVuelosId() {
        return vuelosId;
    }

    public void setVuelosId(Long vuelosId) {
        this.vuelosId = vuelosId;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}
