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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuarios/")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping ("consultar")
	
	private ResponseEntity<List<Usuario>> consultar(){	
		
		return ResponseEntity.ok(usuarioService.findAll());		
		
	}
	
	@GetMapping("consultarById/{id}")
    public ResponseEntity<Usuario> consultarById(@PathVariable("id") Long id) {    
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	
	@PostMapping ("guardar")
	private ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario){
		
		try {
			Usuario usuarioGuardado = usuarioService.save(usuario);
			return ResponseEntity.created(new URI("/usuarios/"+usuarioGuardado.getId())).body(usuarioGuardado);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("actualizar/{id}")
	public ResponseEntity<Usuario> actualizar(@PathVariable("id") Long id, @RequestBody Usuario usuarioActualizado) {
	    Optional<Usuario> usuarioOptional = usuarioService.findById(id);

	    if (!usuarioOptional.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    Usuario usuarioExistente = usuarioOptional.get();
	    usuarioExistente.setNombre(usuarioActualizado.getNombre());
	    usuarioExistente.setApellido(usuarioActualizado.getApellido());
	    // Actualiza los demás campos según necesidad

	    Usuario usuarioActualizadoDB = usuarioService.save(usuarioExistente);

	    return ResponseEntity.ok(usuarioActualizadoDB);
	}
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Long id) {
	    Optional<Usuario> usuarioOptional = usuarioService.findById(id);

	    if (!usuarioOptional.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    Usuario usuario = usuarioOptional.get();
	    usuarioService.delete(usuario);

	    return ResponseEntity.ok().build();
	}
	
	
}
