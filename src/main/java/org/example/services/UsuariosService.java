package org.example.services;

import org.example.dtos.ReservasRequest;
import org.example.dtos.UsuariosRequest;
import org.example.entities.Usuarios;
import org.example.mappers.UsuariosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.repositories.UsuariosRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuariosRequest registrarUsuarios(UsuariosRequest usuariosRequest) {
        Usuarios usuarios = UsuariosMapper.requestToEntity(usuariosRequest);
        usuariosRepositorio.save(usuarios);
        return UsuariosMapper.entityToRequest(usuarios);
    }

    public Optional<Usuarios> buscarPorUsername(String username) {
        return usuariosRepositorio.findByUsername(username);
    }

    public String loginUsuarios(String password) {
        return password;
    }

    public List<ReservasRequest> obtenerReservas(Long usuarioId) {
        return List.of();
    }

    public UsuariosRequest obtenerUsuarios(Long usuarioId) {
        return null;
    }
}
