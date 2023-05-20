package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping
	@RequestMapping(value = "consultar", method = RequestMethod.GET)	
    
	private ResponseEntity<List<Usuario>> consultar(){	
		
		return ResponseEntity.ok(usuarioService.getAllUsuarios());		
		
	}
	
	@GetMapping (value = "consultarById/{id}")	
    
	private ResponseEntity<Optional<Usuario>> consultarById(@PathVariable ("id") int id ){	
		
		return ResponseEntity.ok(usuarioService.findById(id));		
		
	}
	
	@PostMapping()
	@RequestMapping(value = "guardar", method = RequestMethod.POST)	
    
	private ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario){	
		
		Usuario usuarioGuardado = this.usuarioService.create(usuario);
		
		if(usuarioGuardado==null){
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }else{
	        return new ResponseEntity<>(usuarioGuardado, HttpStatus.CREATED);
	    }
		
	}
	
	
	
	
	@DeleteMapping
	@RequestMapping(value = "eliminar/{id}", method = RequestMethod.DELETE)	
    
	private ResponseEntity<Void> eliminar(@RequestBody Usuario usuario){	
		
		usuarioService.delete(usuario);
		
		return ResponseEntity.ok().build();
		
		
	}
}
