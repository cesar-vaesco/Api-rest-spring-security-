package com.vaescode.apirest.restservice.controller;

import java.util.List;

import com.vaescode.apirest.restservice.entity.Profesor;
import com.vaescode.apirest.restservice.service.IProfesorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cesar_Dev
 *
 */
@RestController
@RequestMapping("/v1/api")
public class ProfesorRestController {

	
	private static final Logger log = LoggerFactory.getLogger(ProfesorRestController.class);

	
	@Autowired
	private IProfesorService profesorService;

	// Método login -> requiere correo y contraseña

	@PostMapping("/login")
	public ResponseEntity<?> loginProfesor(@RequestBody Profesor profesor){
		log.info("Profesor: " + profesor);
		Profesor profesorDB = profesorService.checkProfesorLogin(profesor);
		log.info("ProfesorDB: " + profesorDB);

		if(profesorDB != null) {
			return new ResponseEntity<>(profesorDB, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/profesores")
	@ResponseStatus(HttpStatus.OK)
	public List<Profesor> getProfesores() {
		return profesorService.findAll();
	}

	@GetMapping("/profesor/{id}")
	public ResponseEntity<Profesor> getProfesorById(@PathVariable("id") Long id) {

		Profesor profesordb = profesorService.findById(id);

		if (profesordb != null) {
			return new ResponseEntity<Profesor>(profesordb, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
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

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProfesor(@PathVariable(value = "id") Long id) {

		Profesor profesordb = null;

		profesordb = profesorService.findById(id);

		if (profesordb != null) {
			profesorService.deleteProfesor(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("delete")
	public ResponseEntity<?> deleteAllTeachers() {

		List<Profesor> profesores = profesorService.findAll();

		if (profesores.addAll(getProfesores())) {

			profesorService.deleteProfesores();
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

}
