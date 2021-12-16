package com.vaescode.apirest.restservice.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "profesores")
public class Profesor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(length = 60, unique = true)
	private String email;

	private String password;

	@Column(length = 2000)
	private String foto;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@OneToMany(cascade = CascadeType.ALL)// la persistencia se propagará (en cascada) todas las operaciones
	@JoinColumn(name = "profesor_id", referencedColumnName = "id")// profesor_id referencia la relación a el campo id de la clase Curso
	private List<Curso> curso = new ArrayList<>();

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}

	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password
				+ ", createAt=" + createAt + "]";
	}

	private static final long serialVersionUID = 1L;

}
