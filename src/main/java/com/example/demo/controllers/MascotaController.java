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

import com.example.demo.model.Mascota;
import com.example.demo.service.MascotaService;

@RestController
@RequestMapping("/mascotas/")
@CrossOrigin({"*"})
public class MascotaController {
	
	@Autowired
	private MascotaService mascotaService;
	
	@GetMapping ("consultar")
	
	private ResponseEntity<List<Mascota>> consultar(){	
		
		return ResponseEntity.ok(mascotaService.findAll());		
		
	}
	
	@GetMapping("consultarById/{id}")
    public ResponseEntity<Mascota> consultarById(@PathVariable("id") Long id) {    
        Optional<Mascota> mascota = mascotaService.findById(id);
        if (mascota.isPresent()) {
            return ResponseEntity.ok(mascota.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	
	@PostMapping ("guardar")
	private ResponseEntity<Mascota> guardar(@RequestBody Mascota mascota){
		
		try {
			Mascota mascotaGuardado = mascotaService.save(mascota);
			return ResponseEntity.created(new URI("/mascotas/"+mascotaGuardado.getId())).body(mascotaGuardado);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("actualizar/{id}")
	public ResponseEntity<Mascota> actualizar(@PathVariable("id") Long id, @RequestBody Mascota mascotaActualizado) {
	    Optional<Mascota> mascotaOptional = mascotaService.findById(id);

	    if (!mascotaOptional.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    Mascota mascotaExistente = mascotaOptional.get();
	    mascotaExistente.setNombre(mascotaActualizado.getNombre());
	    mascotaExistente.setRaza(mascotaActualizado.getRaza());
	    mascotaExistente.setUsuario(mascotaActualizado.getUsuario());
	    mascotaExistente.setSexo(mascotaActualizado.getSexo());
	    // Se actualiza los demás campos según necesidad

	    Mascota mascotaActualizadoDB = mascotaService.save(mascotaExistente);

	    return ResponseEntity.ok(mascotaActualizadoDB);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Long id) {
	    Optional<Mascota> mascotaOptional = mascotaService.findById(id);

	    if (!mascotaOptional.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    Mascota mascota = mascotaOptional.get();
	    mascotaService.delete(mascota);

	    return ResponseEntity.ok().build();
	}

}
