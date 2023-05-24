package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "Colaborador")
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "especialidad")
	private String especialidad;
	
	@Column(name = "tipo_documento")
	private String tipo_documento;
	
	@Column(name = "documento_identificacion")
	private int documento_identificacion;

	public Colaborador(String nombre, String apellido, String cargo, String especialidad, String tipo_documento,
			int documento_identificacion) {


		this.nombre = nombre;
		this.apellido = apellido;
		this.cargo = cargo;
		this.especialidad = especialidad;
		this.tipo_documento = tipo_documento;
		this.documento_identificacion = documento_identificacion;
	}

	public Colaborador() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public int getDocumento_identificacion() {
		return documento_identificacion;
	}

	public void setDocumento_identificacion(int documento_identificacion) {
		this.documento_identificacion = documento_identificacion;
	}
	
	
	
	
	
	
	

}
