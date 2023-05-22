package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "tipo_documento")
	private char tipo_documento;
	
	@Column(name = "documento_identificacion")
	private int documento_identificacion;
	
	@Column(name = "estado")
	private char estado;
	
	@Column(name = "sexo")
	private int sexo;
	
	
	

	public Usuario(String nombre, String apellido, char tipo_documento, int documento_identificacion, char estado,
			int sexo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo_documento = tipo_documento;
		this.documento_identificacion = documento_identificacion;
		this.estado = estado;
		this.sexo = sexo;
	}
	
	public Usuario() {
		
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

	public char getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(char tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public int getDocumento_identificacion() {
		return documento_identificacion;
	}

	public void setDocumento_identificacion(int documento_identificacion) {
		this.documento_identificacion = documento_identificacion;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	
	
	
	
	
	
}
