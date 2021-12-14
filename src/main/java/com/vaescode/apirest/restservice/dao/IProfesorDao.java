package com.vaescode.apirest.restservice.dao;

import java.util.Optional;

import com.vaescode.apirest.restservice.entity.Profesor;

import org.springframework.data.repository.CrudRepository;

public interface IProfesorDao extends CrudRepository<Profesor, Long> {


    public Profesor findByEmail(String email);

    public Profesor findByEmailAndPassword(String email, String password);

    public Optional <Profesor> findById(Long id);

    /* @Query("select p from Profesor p where p.id=?1")
    public Profesor findByIdSQL(Long id); */
}
