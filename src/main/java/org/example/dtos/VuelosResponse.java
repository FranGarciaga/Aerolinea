package org.example.dtos;

import java.time.LocalDateTime;

public record VuelosResponse(
        Long id,
        String origen,
        String destino,
        LocalDateTime fecha,
        boolean disponible,
        int plazasDisponibles
) {
}