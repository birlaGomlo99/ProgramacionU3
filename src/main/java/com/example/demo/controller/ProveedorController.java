package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Proveedor;
import com.example.demo.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProveedorController {
    @Autowired
    ProveedorRepository proveedorRepository;

    @GetMapping("/proveedores")
    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }


//    @GetMapping("/productosbynombre/{nombre}")
//    public List<Producto> getAllProductosByNombre(@PathVariable(value = "nombre") String nombre) {
////        return productoRepository.spproductosearch(nombre);
//        return productoRepository.findByName(nombre);
//    }

    @PostMapping("/proveedores")
    public Proveedor createProveedor(@Valid @RequestBody Proveedor proveedor) {
        return proveedorRepository.saveAndFlush(proveedor);
    }

    @GetMapping("/proveedores/{id}")
    public Proveedor getProveedorById(@PathVariable(value = "id") Long proveedorId) {
        return proveedorRepository.findById(proveedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor", "id", proveedorId));
    }

    @PutMapping("/proveedores/{id}")
    public Proveedor updateProveedor(@PathVariable(value = "id") Long proveedorId,
                                           @Valid @RequestBody Proveedor proveedorDetails) {
        Proveedor proveedor = proveedorRepository.findById(proveedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor", "id", proveedorId));
        proveedor.nombre = proveedorDetails.nombre;
        proveedor.direccion = proveedorDetails.direccion;
        proveedor.telefono = proveedorDetails.telefono;

        Proveedor updateProveedor = proveedorRepository.saveAndFlush(proveedor);
        return updateProveedor;
    }

    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<?> deleteProveedor(@PathVariable(value = "id") Long proveedorId) {
        Proveedor proveedor = proveedorRepository.findById(proveedorId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor", "id", proveedorId));
        proveedorRepository.delete(proveedor);
        return ResponseEntity.ok().build();
    }
}
