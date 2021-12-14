package com.vaescode.apirest.restservice.service;

import java.util.List;
import java.util.Optional;

import com.vaescode.apirest.restservice.dao.IProfesorDao;
import com.vaescode.apirest.restservice.entity.Profesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    private IProfesorDao profesorDao;

    @Override
    @Transactional(readOnly = true) // readOnly = true, no se ejecuta el insert, update, delete
    public List<Profesor> findAll() {
        return (List<Profesor>) profesorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor findProfesor(Profesor profesor) {
        return (Profesor) profesorDao.findByEmail(profesor.getEmail());
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor checkProfesorLogin(Profesor profesor) {
        return profesorDao.findByEmailAndPassword(profesor.getEmail(), profesor.getPassword());
    }

    @Override
    @Transactional
    public void deleteProfesor(Profesor profesor) {
        profesorDao.deleteById(profesor.getId());
    }

    @Override
    @Transactional
    public Profesor updateProfesor(Profesor profesor) {
        return (Profesor) profesorDao.save(profesor);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Profesor> findProfesorById(Long profesor_id) {
        return (Optional<Profesor>) profesorDao.findById(profesor_id);
    }

    @Override
    @Transactional
    public void deleteProfesor(Long profesor_id) {
        profesorDao.deleteById(profesor_id);
    }

    @Override
    @Transactional(readOnly = true)
    public Profesor findById(Long profesor_id) {
        return profesorDao.findById(profesor_id).orElse(null);
    }

    /* @Override
    @Transactional(readOnly = true)
    public Profesor findByIdSQL(Long id) {
        return profesorDao.findByIdSQL(id);
    } */

    @Override
    @Transactional
    public Profesor saveProfesor(Profesor profesor) {
        return (Profesor) profesorDao.save(profesor);
    }

	@Override
	public void deleteProfesores() {
		profesorDao.deleteAll();
	}

}
