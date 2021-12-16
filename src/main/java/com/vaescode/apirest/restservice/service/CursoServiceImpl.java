package com.vaescode.apirest.restservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaescode.apirest.restservice.dao.CursoDao;
import com.vaescode.apirest.restservice.entity.Curso;

@Service
public class CursoServiceImpl implements ICursoService {

	@Autowired
	private CursoDao cursoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Curso> findAll() {
		return (List<Curso>) cursoDao.findAll();
	}

	@Override
	@Transactional
	public void saveCurso(Curso curso) {
		cursoDao.save(curso);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Curso> getCursosProfesor(Long id) {
		return (List<Curso>)cursoDao.findByProfesorId(id);
	}

}
