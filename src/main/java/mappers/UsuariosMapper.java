package mappers;

import dtos.UsuariosRequest;
import entities.Usuarios;
import org.springframework.stereotype.Service;

@Service
public class UsuariosMapper {

    public UsuariosRequest usuarioToUsuarioRequest(Usuarios usuarios) {
        if (usuarios == null) {
            return null;
        }

        UsuariosRequest usuariosRequest = new UsuariosRequest();
        usuariosRequest.setId(usuarios.getId());
        usuariosRequest.setNombre(usuarios.getUserName());;
        usuariosRequest.setRol(usuarios.getRole());
        usuariosRequest.setImagenPerfil(usuarios.getProfileImage());

        return usuariosRequest;
    }

    public Usuarios usuariosRequestToUsuario(UsuariosRequest usuariosRequest) {
        if (usuariosRequest == null) {
            return null;
        }

        Usuarios usuarios = new Usuarios();
        usuarios.setId(usuariosRequest.getId());
        usuarios.setUsername(usuariosRequest.getNombre());
        usuarios.setRole(usuariosRequest.getRol());
        usuarios.setProfileImage(usuariosRequest.getImagenPerfil());

        return usuarios;
    }
}
