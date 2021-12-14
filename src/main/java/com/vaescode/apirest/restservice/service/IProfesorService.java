package com.vaescode.apirest.restservice.service;

import java.util.List;
import java.util.Optional;

import com.vaescode.apirest.restservice.entity.Profesor;

public interface IProfesorService {

    public List<Profesor> findAll();

    public Profesor findProfesor(Profesor profesor);

    public Profesor checkProfesorLogin(Profesor profesor);

    public void deleteProfesor(Profesor profesor);

    public Profesor updateProfesor(Profesor profesor);

    public Optional<Profesor> findProfesorById(Long profesor_id);

    public void deleteProfesor(Long profesor_id);

    public Profesor findById(Long profesor_id);

    /* public Profesor findByIdSQL(Long id); */

    public Profesor saveProfesor(Profesor profesor);
    
    
   public void deleteProfesores();

}
