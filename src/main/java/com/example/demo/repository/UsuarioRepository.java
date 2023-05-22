package com.example.demo.repository;

import org.springframework.data.jpa.repository.*;

import com.example.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
