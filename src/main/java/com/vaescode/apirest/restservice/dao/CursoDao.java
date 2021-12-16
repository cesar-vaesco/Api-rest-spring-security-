package com.vaescode.apirest.restservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vaescode.apirest.restservice.entity.Curso;

public interface CursoDao extends CrudRepository<Curso, Long> {

	public List<Curso> findByProfesorId(Long id);
	
}
