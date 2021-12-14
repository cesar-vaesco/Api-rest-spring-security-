package com.vaescode.apirest.restservice.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import com.vaescode.apirest.restservice.entity.Profesor;

public interface IProfesorDao extends CrudRepository<Profesor, Long> {


    public Profesor findByEmail(String email);

    public Profesor findByEmailAndPassword(String email, String password);

    public Optional <Profesor> findById(Long id);

    @Query("SELECT p FROM Profesor p WHERE p.id = ?1")
    public Profesor findByIdSQL(Long id);
}
