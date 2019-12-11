package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Trabajador;
import com.example.demo.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class TrabajadorController {
    @Autowired
    TrabajadorRepository trabajadorRepository;

    @GetMapping("/trabajadores")
    public List<Trabajador> getAllTrabajadores() {
        return trabajadorRepository.findAll();
    }


//    @GetMapping("/productosbynombre/{nombre}")
//    public List<Producto> getAllProductosByNombre(@PathVariable(value = "nombre") String nombre) {
////        return productoRepository.spproductosearch(nombre);
//        return productoRepository.findByName(nombre);
//    }

    @PostMapping("/trabajadores")
    public Trabajador createTrabajador(@Valid @RequestBody Trabajador trabajador) {
        return trabajadorRepository.saveAndFlush(trabajador);
    }

    @GetMapping("/trabajadores/{id}")
    public Trabajador getTrabajadorById(@PathVariable(value = "id") Long trabajadorId) {
        return trabajadorRepository.findById(trabajadorId)
                .orElseThrow(() -> new ResourceNotFoundException("Trabajador", "id", trabajadorId));
    }

    @PutMapping("/trabajadores/{id}")
    public Trabajador updateTrabajador(@PathVariable(value = "id") Long trabajadorId,
                                           @Valid @RequestBody Trabajador trabajadorDetails) {
        Trabajador trabajador = trabajadorRepository.findById(trabajadorId)
                .orElseThrow(() -> new ResourceNotFoundException("Trabajador", "id", trabajadorId));
        trabajador.nombre = trabajadorDetails.nombre;
        trabajador.direccion = trabajadorDetails.direccion;
        trabajador.turno = trabajadorDetails.turno;

        Trabajador updatedTrabajador = trabajadorRepository.saveAndFlush(trabajador);
        return updatedTrabajador;
    }

    @DeleteMapping("/trabajadores/{id}")
    public ResponseEntity<?> deleteTrabajador(@PathVariable(value = "id") Long trabajadorId) {
        Trabajador trabajador = trabajadorRepository.findById(trabajadorId)
                .orElseThrow(() -> new ResourceNotFoundException("Trabajador", "id", trabajadorId));
        trabajadorRepository.delete(trabajador);
        return ResponseEntity.ok().build();
    }
}
