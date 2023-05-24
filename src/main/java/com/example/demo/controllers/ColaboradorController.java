package com.example.demo.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Colaborador;
import com.example.demo.service.ColaboradorService;

@RestController
@RequestMapping("/colaboradores/")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping ("consultar")
	
	private ResponseEntity<List<Colaborador>> consultar(){	
		
		return ResponseEntity.ok(colaboradorService.findAll());		
		
	}
	
	@GetMapping("consultarById/{id}")
    public ResponseEntity<Colaborador> consultarById(@PathVariable("id") Long id) {    
        Optional<Colaborador> colaborador = colaboradorService.findById(id);
        if (colaborador.isPresent()) {
            return ResponseEntity.ok(colaborador.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	
	@PostMapping ("guardar")
	private ResponseEntity<Colaborador> guardar(@RequestBody Colaborador colaborador){
		
		try {
			Colaborador colaboradorGuardado = colaboradorService.save(colaborador);
			return ResponseEntity.created(new URI("/colaboradores/"+colaboradorGuardado.getId())).body(colaboradorGuardado);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("actualizar/{id}")
	public ResponseEntity<Colaborador> actualizar(@PathVariable("id") Long id, @RequestBody Colaborador colaboradorActualizado) {
	    Optional<Colaborador> colaboradorOptional = colaboradorService.findById(id);

	    if (!colaboradorOptional.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    Colaborador colaboradorExistente = colaboradorOptional.get();
	    colaboradorExistente.setNombre(colaboradorActualizado.getNombre());
	    colaboradorExistente.setApellido(colaboradorActualizado.getApellido());
	    colaboradorExistente.setCargo(colaboradorActualizado.getCargo());
	    colaboradorExistente.setEspecialidad(colaboradorActualizado.getEspecialidad());
	    colaboradorExistente.setTipo_documento(colaboradorActualizado.getTipo_documento());
	    colaboradorExistente.setDocumento_identificacion(colaboradorActualizado.getDocumento_identificacion());
	    // Se actualiza los demás campos según necesidad

	    Colaborador colaboradorActualizadoDB = colaboradorService.save(colaboradorExistente);

	    return ResponseEntity.ok(colaboradorActualizadoDB);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Long id) {
	    Optional<Colaborador> colaboradorOptional = colaboradorService.findById(id);

	    if (!colaboradorOptional.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    Colaborador colaborador = colaboradorOptional.get();
	    colaboradorService.delete(colaborador);

	    return ResponseEntity.ok().build();
	}
	
	

}
