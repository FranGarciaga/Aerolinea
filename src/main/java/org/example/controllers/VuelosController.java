package org.example.controllers;

import org.example.dtos.VuelosRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.services.VuelosService;

import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
public class VuelosController {

    @Autowired
    private VuelosService vuelosService;

    @PostMapping
    public ResponseEntity<VuelosRequest> crearVuelos(@RequestBody VuelosRequest vuelosRequest) {
        VuelosRequest creado = vuelosService.crearVuelos(vuelosRequest);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VuelosRequest>> obtenerVuelos() {
        List<VuelosRequest> vuelos = vuelosService.obtenerVuelos();
        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VuelosRequest> obtenerVuelos(@PathVariable Long id) {
        VuelosRequest vuelos = vuelosService.obtenerVuelo(id);
        return new ResponseEntity<>(vuelos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VuelosRequest> actualizarVuelos(@PathVariable Long id, @RequestBody VuelosRequest vuelosRequest) {
        VuelosRequest actualizado = vuelosService.actualizarVuelos(id, vuelosRequest);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVuelos(@PathVariable Long id) {
        vuelosService.eliminarVuelo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}