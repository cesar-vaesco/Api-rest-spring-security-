package com.vaescode.apirest.restservice.service;

import java.util.List;

import com.vaescode.apirest.restservice.entity.Curso;

public interface ICursoService {

	public List<Curso> findAll();
	
	public void saveCurso(Curso curso);
	
	public List<Curso> getCursosProfesor(Long id);
}
