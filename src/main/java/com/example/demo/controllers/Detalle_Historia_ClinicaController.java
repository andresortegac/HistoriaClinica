package com.example.demo.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Detalle_Historia_Clinica;
import com.example.demo.service.Detalle_Historia_ClinicaService;

@RestController
@RequestMapping("/detalle_historia_clinica/")
@CrossOrigin({"*"})
public class Detalle_Historia_ClinicaController {

	@Autowired
	private Detalle_Historia_ClinicaService detalle_historia_clinicaService;
	
	@GetMapping ("consultar")
	
	private ResponseEntity<List<Detalle_Historia_Clinica>> consultar(){	
		
		return ResponseEntity.ok(detalle_historia_clinicaService.findAll());		
		
	}
	
	@GetMapping("consultarById/{id}")
    public ResponseEntity<Detalle_Historia_Clinica> consultarById(@PathVariable("id") Long id) {    
        Optional<Detalle_Historia_Clinica> detalle_historia_clinica = detalle_historia_clinicaService.findById(id);
        if (detalle_historia_clinica.isPresent()) {
            return ResponseEntity.ok(detalle_historia_clinica.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	
	@PostMapping ("guardar")
	private ResponseEntity<Detalle_Historia_Clinica> guardar(@RequestBody Detalle_Historia_Clinica detalle_historia_clinica){
		
		try {
			Detalle_Historia_Clinica detalle_historia_clinicaGuardado = detalle_historia_clinicaService.save(detalle_historia_clinica);
			return ResponseEntity.created(new URI("/historia_clinica/"+detalle_historia_clinicaGuardado.getId())).body(detalle_historia_clinicaGuardado);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("actualizar/{id}")
	public ResponseEntity<Detalle_Historia_Clinica> actualizar(@PathVariable("id") Long id, @RequestBody Detalle_Historia_Clinica detalle_historia_clinicaActualizado) {
	    Optional<Detalle_Historia_Clinica> detalle_historia_clinicaOptional = detalle_historia_clinicaService.findById(id);

	    if (!detalle_historia_clinicaOptional.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    Detalle_Historia_Clinica detalle_historia_clinicaExistente = detalle_historia_clinicaOptional.get();
	    detalle_historia_clinicaExistente.setTemperatura(detalle_historia_clinicaActualizado.getTemperatura());
	    detalle_historia_clinicaExistente.setPeso(detalle_historia_clinicaActualizado.getPeso());
	    detalle_historia_clinicaExistente.setFrecuenciaCardiaca(detalle_historia_clinicaActualizado.getFrecuenciaCardiaca());
	    detalle_historia_clinicaExistente.setFrecuenciaRespiratoria(detalle_historia_clinicaActualizado.getFrecuenciaRespiratoria());
	    detalle_historia_clinicaExistente.setFechaHora(detalle_historia_clinicaActualizado.getFechaHora());
	    detalle_historia_clinicaExistente.setAlimentacion(detalle_historia_clinicaActualizado.getAlimentacion());
	    detalle_historia_clinicaExistente.setHabitad(detalle_historia_clinicaActualizado.getHabitad());
	    detalle_historia_clinicaExistente.setObservacion(detalle_historia_clinicaActualizado.getObservacion());
	    detalle_historia_clinicaExistente.setColaborador(detalle_historia_clinicaActualizado.getColaborador());
	    detalle_historia_clinicaExistente.setHistoria_clinica(detalle_historia_clinicaActualizado.getHistoria_clinica());
	    // Se actualiza los demás campos según necesidad

	    Detalle_Historia_Clinica detalle_historia_clinicaActualizadoDB = detalle_historia_clinicaService.save(detalle_historia_clinicaExistente);

	    return ResponseEntity.ok(detalle_historia_clinicaActualizadoDB);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Long id) {
	    Optional<Detalle_Historia_Clinica> detalle_historia_clinicaOptional = detalle_historia_clinicaService.findById(id);

	    if (!detalle_historia_clinicaOptional.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    Detalle_Historia_Clinica detalle_historia_clinica = detalle_historia_clinicaOptional.get();
	    detalle_historia_clinicaService.delete(detalle_historia_clinica);

	    return ResponseEntity.ok().build();
	}

}
