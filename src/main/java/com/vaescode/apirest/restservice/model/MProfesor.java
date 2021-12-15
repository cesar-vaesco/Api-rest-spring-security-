package com.vaescode.apirest.restservice.model;

import com.vaescode.apirest.restservice.entity.Profesor;

public class MProfesor {

	private Long id;
	private String nombre;
	private String email;
	private String foto;

	public MProfesor() {
	}

	public MProfesor(Long id, String nombre, String email, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.foto = foto;
	}

	//Método que permite solamente cargar atributos que se quiere mostrar a la vista
	public MProfesor(Profesor profesor) {
		this.id = profesor.getId();
		this.nombre = profesor.getNombre();
		this.email = profesor.getEmail();
		this.foto = profesor.getFoto();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
