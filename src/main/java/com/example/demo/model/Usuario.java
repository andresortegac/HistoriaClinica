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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
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
	
	
	
	
	
	
}
