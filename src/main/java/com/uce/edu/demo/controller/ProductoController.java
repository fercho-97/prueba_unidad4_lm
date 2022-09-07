package com.uce.edu.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.IVentaRepository;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.VentaReporte;
import com.uce.edu.demo.service.IGestorService;
import com.uce.edu.demo.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IGestorService iGestorService;
	
	
	

	@PostMapping("/ingresar") // "/agendar"
	public String insertarNuevoProducto(Producto producto) {
		this.iProductoService.insertar(producto);

		return "redirect:/productos/buscar";

	}

	// Get-Buscar
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Producto> lista = this.iProductoService.buscarTodos();
		modelo.addAttribute("productos", lista);// personas
		return "vistaListaProductos";
	}
	
	@GetMapping("/nuevoProducto")
	public String paginaNuevaCita(Producto producto) {
		return "vistaIngreso";

	}
	
	
	// Get-Buscar
		@GetMapping("/reporte/{fecha}")//"/buscar"
		public String realizarReporte(@PathVariable("fecha") LocalDateTime fecha, String categoria, Integer cantidad, Model modelo) {
			List<VentaReporte> lista = this.iGestorService.buscaPorFecha(fecha, categoria, cantidad);
			modelo.addAttribute("ventaReportes", lista);// personas
			return "vistaReporte";
	
		}
		
		
		
		
		/*
		 
		 @GetMapping("citaActualiza/{numCita}")
		public String  obtenerPaginaActualizarCita(@PathVariable("numCita") String numCita, CitaMedica cita, Model modelo) {
			CitaMedica citaMedica=this.citaService.buscarNumero(numCita);
			modelo.addAttribute("cita", citaMedica);
			return "citaActualiza";
			
		}
	
		 */
		
		
		
}
