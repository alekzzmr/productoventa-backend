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
import com.alekzmr.core.models.Persona;
import com.alekzmr.core.services.IPersonaService;

@RestController
@RequestMapping("persona")
public class PersonaController {
	
	@Autowired
	private IPersonaService service;
	
	@GetMapping
	public ResponseEntity<List<Persona>> listar() throws Exception{
		List<Persona> personas = service.listar();
		return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> buscarPorId(@PathVariable("id") Integer Id) throws Exception{
		Persona persona = service.buscarPorId(Id);
		Persona obj = service.buscarPorId(Id);
		if(obj == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + Id);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Persona p) throws Exception{
		Persona persona = service.registrar(p);		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(persona.getIdPersona()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Persona> modificar(@Valid @RequestBody Persona p) throws Exception{
		Persona persona = service.modificar(p);		
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer Id) throws Exception{
		Persona obj = service.buscarPorId(Id);
		if(obj == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + Id);
		}
		service.eliminar(Id);		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
