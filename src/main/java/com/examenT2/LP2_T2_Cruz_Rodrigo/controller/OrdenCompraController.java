package com.examenT2.LP2_T2_Cruz_Rodrigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.LP2_T2_Cruz_Rodrigo.model.OrdenCompraCR;
import com.examenT2.LP2_T2_Cruz_Rodrigo.repository.ProveedorRepository;
import com.examenT2.LP2_T2_Cruz_Rodrigo.service.OrdenCompraService;
import com.examenT2.LP2_T2_Cruz_Rodrigo.service.ProveedorService;
import com.examenT2.LP2_T2_Cruz_Rodrigo.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("inventario")
@RequiredArgsConstructor
public class OrdenCompraController {

	private final OrdenCompraService ordenCompraService;
	private final ProveedorService proveedorService;


	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstOrdenes", ordenCompraService.getAll());
		return "inventario/listado";
	}

	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("lstProveedores", proveedorService.getAll());

		// Inicializa el objeto del formulario
		model.addAttribute("ordenCompra", new OrdenCompraCR());

		return "inventario/nuevo";
	}

	@PostMapping("registrar")
	public String registrar(@ModelAttribute OrdenCompraCR ordenCompra, RedirectAttributes flash) {

		var response = ordenCompraService.create(ordenCompra);

		var alert = Alert.sweetToast(response.mensaje(), "success", 5000);

		flash.addFlashAttribute("alert", alert);

		return "redirect:/inventario/listado";
	}

	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {

		model.addAttribute("lstProveedores", proveedorService.getAll());

		model.addAttribute("ordenCompra", ordenCompraService.getOne(id));

		return "inventario/edicion";
	}

	@PostMapping("guardar")
	public String guardar(@ModelAttribute OrdenCompraCR ordenCompra, RedirectAttributes flash) {

		var response = ordenCompraService.update(ordenCompra);

		var alert = Alert.sweetToast(response.mensaje(), "success", 5000);

		flash.addFlashAttribute("alert", alert);

		return "redirect:/inventario/listado";
	}
}