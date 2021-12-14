package com.vaescode.apirest.restservice.controller;

import java.util.List;

import com.vaescode.apirest.restservice.entity.Profesor;
import com.vaescode.apirest.restservice.service.IProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProfesorRestController {

	@Autowired
	private IProfesorService profesorService;

	@GetMapping("/profesores")
	@ResponseStatus(HttpStatus.OK)
	public List<Profesor> getProfesores() {
		return profesorService.findAll();
	}

	@PostMapping("/sign_up")
	public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor) {

		if (profesorService.findProfesor(profesor) == null) {
			profesorService.saveProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProfesor(@PathVariable(value = "id") Long id, @RequestBody Profesor profesor) {

		Profesor profesordb = null;

		profesordb = profesorService.findById(id);

		if (profesordb != null) {

			profesordb.setNombre(profesor.getNombre());
			profesordb.setEmail(profesor.getEmail());
			
			profesorService.updateProfesor(profesordb);
			
			return new ResponseEntity<>(profesordb, HttpStatus.OK);
			
		} else {

			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}
}
