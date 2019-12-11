package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Venta;
import com.example.demo.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VentaController {
    @Autowired
    VentaRepository ventaRepository;

    @GetMapping("/ventas")
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }


//    @GetMapping("/productosbynombre/{nombre}")
//    public List<Producto> getAllProductosByNombre(@PathVariable(value = "nombre") String nombre) {
////        return productoRepository.spproductosearch(nombre);
//        return productoRepository.findByName(nombre);
//    }

    @PostMapping("/ventas")
    public Venta createVenta(@Valid @RequestBody Venta venta) {
        return ventaRepository.saveAndFlush(venta);
    }

    @GetMapping("/ventas/{id}")
    public Venta getVentaById(@PathVariable(value = "id") Long ventaId) {
        return ventaRepository.findById(ventaId)
                .orElseThrow(() -> new ResourceNotFoundException("Venta", "id", ventaId));
    }

    @PutMapping("/ventas/{id}")
    public Venta updateVenta(@PathVariable(value = "id") Long ventaId,
                                           @Valid @RequestBody Venta ventaDetails) {
        Venta venta = ventaRepository.findById(ventaId)
                .orElseThrow(() -> new ResourceNotFoundException("Venta", "id", ventaId));
        venta.nombre = ventaDetails.nombre;
        venta.descripcion = ventaDetails.descripcion;
        venta.precio = ventaDetails.precio;

        Venta updateVenta = ventaRepository.saveAndFlush(venta);
        return updateVenta;
    }

    @DeleteMapping("/ventas/{id}")
    public ResponseEntity<?> deleteVenta(@PathVariable(value = "id") Long ventaId) {
        Venta venta = ventaRepository.findById(ventaId)
                .orElseThrow(() -> new ResourceNotFoundException("Venta", "id", ventaId));
        ventaRepository.delete(venta);
        return ResponseEntity.ok().build();
    }
}
