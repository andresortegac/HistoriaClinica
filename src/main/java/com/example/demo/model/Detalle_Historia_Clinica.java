package com.example.demo.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_historia_clinica")
public class Detalle_Historia_Clinica {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "temperatura", nullable = false)
    private String temperatura;

    @Column(name = "peso", nullable = false)
    private BigDecimal peso;

    @Column(name = "frecuencia_cardiaca", nullable = false)
    private BigDecimal frecuenciaCardiaca;

    @Column(name = "frecuencia_respiratoria", nullable = false)
    private BigDecimal frecuenciaRespiratoria;

    @Column(name = "fecha_hora", nullable = false)
    private Timestamp fechaHora;

    @Column(name = "alimentacion", nullable = false)
    private String alimentacion;

    @Column(name = "habitad", nullable = false)
    private String habitad;

    @Column(name = "observacion", nullable = false)
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "colaborador_id", referencedColumnName = "id")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "historia_clinica_id", referencedColumnName = "id")
    private Historia_Clinica historia_clinica;

	public Detalle_Historia_Clinica(String temperatura, BigDecimal peso, BigDecimal frecuenciaCardiaca,
			BigDecimal frecuenciaRespiratoria, Timestamp fechaHora, String alimentacion, String habitad,
			String observacion, Colaborador colaborador, Historia_Clinica historia_clinica) {
		this.temperatura = temperatura;
		this.peso = peso;
		this.frecuenciaCardiaca = frecuenciaCardiaca;
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
		this.fechaHora = fechaHora;
		this.alimentacion = alimentacion;
		this.habitad = habitad;
		this.observacion = observacion;
		this.colaborador = colaborador;
		this.historia_clinica = historia_clinica;
	}

	public Detalle_Historia_Clinica() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(BigDecimal frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}

	public BigDecimal getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}

	public void setFrecuenciaRespiratoria(BigDecimal frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
	}

	public Timestamp getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}

	public String getHabitad() {
		return habitad;
	}

	public void setHabitad(String habitad) {
		this.habitad = habitad;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Historia_Clinica getHistoria_clinica() {
		return historia_clinica;
	}

	public void setHistoria_clinica(Historia_Clinica historia_clinica) {
		this.historia_clinica = historia_clinica;
	}
    
	
    
}
