package org.example.dtos;

import java.time.LocalDateTime;

public record ReservasResponse(
        Long id,
        LocalDateTime fechaReserva,
        int cantidad,
        Long usuarioId,
        Long vueloId
) {
}