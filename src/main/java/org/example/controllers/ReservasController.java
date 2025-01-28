package org.example.controllers;

import org.example.dtos.ReservasRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.services.ReservasService;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservasController {

    @Autowired
    private ReservasService reservasService;

    @PostMapping
    public ResponseEntity<ReservasRequest> crearReservas(@RequestBody ReservasRequest reservasRequest) {
        ReservasRequest creada = reservasService.crearReservas(reservasRequest);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservasRequest> obtenerReservas(@PathVariable Long id) {
        ReservasRequest reservas = reservasService.obtenerReservas(id);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ReservasRequest>> obtenerReservasPorUsuario(@PathVariable Long usuarioId) {
        List<ReservasRequest> reservas = reservasService.obtenerReservasPorUsuario(usuarioId);
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }
}
