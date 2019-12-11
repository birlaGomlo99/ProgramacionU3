package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PersonaController {
    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/personas")
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }


//    @GetMapping("/productosbynombre/{nombre}")
//    public List<Producto> getAllProductosByNombre(@PathVariable(value = "nombre") String nombre) {
////        return productoRepository.spproductosearch(nombre);
//        return productoRepository.findByName(nombre);
//    }

    @PostMapping("/personas")
    public Persona createPersona(@Valid @RequestBody Persona persona) {
        return personaRepository.saveAndFlush(persona);
    }

    @GetMapping("/personas/{id}")
    public Persona getPersonaById(@PathVariable(value = "id") Long personaId) {
        return personaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));
    }

    @PutMapping("/personas/{id}")
    public Persona updatePersona(@PathVariable(value = "id") Long personaId,
                                           @Valid @RequestBody Persona personaDetails) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));
        persona.nombre = personaDetails.nombre;
        persona.apellido = personaDetails.apellido;
        persona.telefono = personaDetails.telefono;

        Persona updatePersona = personaRepository.saveAndFlush(persona);
        return updatePersona;
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable(value = "id") Long personaId) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));
        personaRepository.delete(persona);
        return ResponseEntity.ok().build();
    }
}
