package org.example.dtos;

public record UsuariosResponse(
        Long id, String username,
        String role,
        String profileImage
) {
}