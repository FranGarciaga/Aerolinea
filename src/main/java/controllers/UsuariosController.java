package controllers;

import dtos.UsuariosRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UsuariosService;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/registro")
    public ResponseEntity<UsuariosRequest> registrarUsuario(@RequestBody UsuariosRequest usuariosRequest) {
        UsuariosRequest creado = usuariosService.registrarUsuarios(usuariosRequest);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUsuarios( @RequestParam String contraseña) {
        String token = usuariosService.loginUsuarios(contraseña);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping("/reservas/{usuarioId}")
    public ResponseEntity<List<ReservaDTO>> obtenerReservas(@PathVariable Long usuarioId) {
        List<ReservaDTO> reservas = usuarioService.obtenerReservas(usuarioId);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable Long usuarioId) {
        UsuarioDTO usuario = usuarioService.obtenerUsuario(usuarioId);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
