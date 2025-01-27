package services;

import entities.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repositories.UsuariosRepositorio;

import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuarios registrarUsuarios(Usuarios usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuariosRepositorio.save(usuario);
    }

    public Optional<Usuarios> buscarPorUsername(String username) {
        return usuariosRepositorio.findByUsername(username);
    }
}
