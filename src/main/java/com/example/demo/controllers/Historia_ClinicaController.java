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

import com.example.demo.model.Historia_Clinica;
import com.example.demo.service.Historia_ClinicaService;

@RestController
@RequestMapping("/historia_clinica/")
@CrossOrigin({"*"})
public class Historia_ClinicaController {
	
	@Autowired
	private Historia_ClinicaService historia_clinicaService;
	
	@GetMapping ("consultar")
	
	private ResponseEntity<List<Historia_Clinica>> consultar(){	
		
		return ResponseEntity.ok(historia_clinicaService.findAll());		
		
	}
	
	@GetMapping("consultarById/{id}")
    public ResponseEntity<Historia_Clinica> consultarById(@PathVariable("id") Long id) {    
        Optional<Historia_Clinica> historia_clinica = historia_clinicaService.findById(id);
        if (historia_clinica.isPresent()) {
            return ResponseEntity.ok(historia_clinica.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	
	@PostMapping ("guardar")
	private ResponseEntity<Historia_Clinica> guardar(@RequestBody Historia_Clinica historia_clinica){
		
		try {
			Historia_Clinica historia_clinicaGuardado = historia_clinicaService.save(historia_clinica);
			return ResponseEntity.created(new URI("/historia_clinica/"+historia_clinicaGuardado.getId())).body(historia_clinicaGuardado);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("actualizar/{id}")
	public ResponseEntity<Historia_Clinica> actualizar(@PathVariable("id") Long id, @RequestBody Historia_Clinica historia_clinicaActualizado) {
	    Optional<Historia_Clinica> historia_clinicaOptional = historia_clinicaService.findById(id);

	    if (!historia_clinicaOptional.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    Historia_Clinica historia_clinicaExistente = historia_clinicaOptional.get();
	    historia_clinicaExistente.setMascota(historia_clinicaActualizado.getMascota());
	    historia_clinicaExistente.setFecha_creacion(historia_clinicaActualizado.getFecha_creacion());
	    // Se actualiza los demás campos según necesidad

	    Historia_Clinica historia_clinicaActualizadoDB = historia_clinicaService.save(historia_clinicaExistente);

	    return ResponseEntity.ok(historia_clinicaActualizadoDB);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Long id) {
	    Optional<Historia_Clinica> historia_clinicaOptional = historia_clinicaService.findById(id);

	    if (!historia_clinicaOptional.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    Historia_Clinica historia_clinica = historia_clinicaOptional.get();
	    historia_clinicaService.delete(historia_clinica);

	    return ResponseEntity.ok().build();
	}


}
