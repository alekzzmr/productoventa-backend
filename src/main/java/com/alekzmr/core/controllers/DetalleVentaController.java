package com.alekzmr.core.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alekzmr.core.models.DetalleVenta;


@RestController
@RequestMapping("detalle-venta")
public class DetalleVentaController {
	@GetMapping
	public ResponseEntity<List<DetalleVenta>> listar() throws Exception{
		return null;
	}
}
