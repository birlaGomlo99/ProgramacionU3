package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.model.Persona;
import com.example.demo.model.Trabajador;
import com.example.demo.model.Venta;
import com.example.demo.model.Proveedor;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.repository.TrabajadorRepository;
import com.example.demo.repository.VentaRepository;
import com.example.demo.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class PagesController {
	@Autowired
	ProductoRepository productoRepository;


	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Hola Mundo !!");
		for (Producto p: productoRepository.findAll() ) {
			System.out.println(p.nombre);
		}
		model.addAttribute("productos", productoRepository.findAll());
		return "index";
	}

	@Autowired
	PersonaRepository personaRepository;
	@RequestMapping("/next")
	public String next(Model model) {
		for (Persona p: personaRepository.findAll() ) {
			System.out.println(p.nombre);
		}
		model.addAttribute("personas", personaRepository.findAll());
	    return "next";
	}

	@Autowired
	TrabajadorRepository trabajadorRepository;
	@RequestMapping("/trabajador")
	public String trabajador(Model model) {
		for (Trabajador p: trabajadorRepository.findAll() ) {
			System.out.println(p.nombre);
		}
		model.addAttribute("trabajador", trabajadorRepository.findAll());
	    return "trabajador";
	}


	@Autowired
	VentaRepository ventaRepository;
	@RequestMapping("/venta")
	public String venta(Model model) {
		//for (Trabajador p: trabajadorRepository.findAll() ) {
		//	System.out.println(p.nombre);
		//}
		model.addAttribute("venta", ventaRepository.findAll());
	    return "venta";
	}


	@Autowired
	ProveedorRepository proveedorRepository;
	@RequestMapping("/proveedor")
	public String proveedor(Model model) {
		//for (Trabajador p: trabajadorRepository.findAll() ) {
		//	System.out.println(p.nombre);
		//}
		model.addAttribute("proveedor", proveedorRepository.findAll());
	    return "proveedor";
	}


}