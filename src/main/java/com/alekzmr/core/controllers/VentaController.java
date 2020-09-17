package com.alekzmr.core.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alekzmr.core.exception.ModelNotFoundException;
import com.alekzmr.core.models.Venta;
import com.alekzmr.core.services.IVentaService;

@RestController
@RequestMapping("venta")
public class VentaController {
	
	@Autowired
	private IVentaService service;
	
	@GetMapping
	public ResponseEntity<List<Venta>> listar() throws Exception{
		 List<Venta> venta = service.listar();
		
		return new ResponseEntity<List<Venta>>(venta, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Venta> buscarPorId(@PathVariable Integer id) throws Exception{
		Venta venta = service.buscarPorId(id);
		if(venta == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<Venta>(venta, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Venta v) throws Exception{
		Venta venta = service.registrarTransaccional(v);		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venta.getIdVenta()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta v) throws Exception{
		Venta venta = service.modificarTransaccional(v);
		
		return new ResponseEntity<Venta>(venta, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		service.eliminarTransaccional(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
