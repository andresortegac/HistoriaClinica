package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UsuarioRepository;
import com.example.demo.model.Usuario;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<Usuario> getAllUsuarios () {
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> findById(int id) {
		return usuarioRepository.findById(id);
	}
	
	public Usuario create (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario update(Usuario usuario) {		
		return this.usuarioRepository.save(usuario);
	}
	
	public void delete (Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

}
