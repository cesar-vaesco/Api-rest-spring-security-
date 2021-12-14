package com.vaescode.apirest.restservice.controller;

import java.util.List;

import com.vaescode.apirest.restservice.entity.Profesor;
import com.vaescode.apirest.restservice.service.IProfesorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profesor")
public class ProfesorRestController {


    @Autowired
    private IProfesorService profesorService;

    @GetMapping("/profesores")
    public List<Profesor> getPtofesores(){
        return profesorService.findAll();
    }

    @PostMapping("/sign_up")
    public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor){

        if(profesorService.findProfesor(profesor)  == null){
            profesorService.saveProfesor(profesor);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }
}
