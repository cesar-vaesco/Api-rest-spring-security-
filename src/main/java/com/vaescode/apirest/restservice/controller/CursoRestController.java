package com.vaescode.apirest.restservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.apirest.restservice.entity.Curso;
import com.vaescode.apirest.restservice.service.ICursoService;

@RestController
@RequestMapping("/v1/api")
public class CursoRestController {

	
	
	private static final Logger log = LoggerFactory.getLogger(CursoRestController.class);

	@Autowired
	private ICursoService cursoService;

	@GetMapping("/cursos")
	public ResponseEntity<?> listaCursos() {

		List<Curso> listaCursos = cursoService.findAll();
		if (listaCursos != null && listaCursos.size() != 0) {
			return new ResponseEntity<>(listaCursos, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create-courses")
	public ResponseEntity<Void> addCursos(@RequestBody Curso curso){
		log.info("Curso: " + curso.getNombreCurso());
		log.info("Curso: " + curso.getProfesorId());

		if(cursoService.getCursosProfesor(curso.getCurso_id()) == null) {
			cursoService.saveCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	/*
	 * 	@PostMapping("/sign_up")
	public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor) {

		if (profesorService.findProfesor(profesor) == null) {
			profesorService.saveProfesor(profesor);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	 * 
	 * */

}
