package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfazServicio.IempleadoService;
import com.example.demo.modelo.Empleado;
@Controller
@RequestMapping
public class Controlador {
	@Autowired
	private IempleadoService servicio;
	
	@GetMapping("/listar")
	public String listar(Model model)
	{
		List<Empleado> empleados=servicio.listar();
		model.addAttribute("empleados", empleados);
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "formulario"; 
	}
	
	
	@PostMapping("/guardar")
	public String guardar(@Validated Empleado e , Model model) {
		servicio.guardar(e);
		return "redirect:/listar";
	}
	
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id ,Model model) {
		Optional<Empleado> empleado=servicio.buscarId(id);
		model.addAttribute("empleado", empleado);
		return "formulario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String borrar(Model model, @PathVariable int id) {
		servicio.eliminar(id);
		return "redirect:/listar";
	}
}
