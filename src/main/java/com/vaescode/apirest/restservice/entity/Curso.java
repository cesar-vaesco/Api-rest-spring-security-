package com.vaescode.apirest.restservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long curso_id;

	@Column(name = "nombre_curso")
	private String nombreCurso;

	@Column(name = "profesor_id")
	private String profesorId;

	public Curso() {
	}

	public Long getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(Long curso_id) {
		this.curso_id = curso_id;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(String profesorId) {
		this.profesorId = profesorId;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
