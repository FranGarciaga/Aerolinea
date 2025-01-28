package org.example.controllers;

import org.example.dtos.ReservasRequest;
import org.example.dtos.UsuariosRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.services.UsuariosService;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/registro")
    public ResponseEntity<UsuariosRequest> registrarUsuarios(@RequestBody UsuariosRequest usuariosRequest) {
        UsuariosRequest creado = usuariosService.registrarUsuarios(usuariosRequest);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUsuarios( @RequestParam String password) {
        String token = usuariosService.loginUsuarios(password);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping("/reservas/{usuarioId}")
    public ResponseEntity<List<ReservasRequest>> obtenerReservas(@PathVariable Long usuarioId) {
        List<ReservasRequest> reservas = usuariosService.obtenerReservas(usuarioId);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuariosRequest> obtenerUsuarios(@PathVariable Long usuarioId) {
        UsuariosRequest usuarios = usuariosService.obtenerUsuarios(usuarioId);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}
