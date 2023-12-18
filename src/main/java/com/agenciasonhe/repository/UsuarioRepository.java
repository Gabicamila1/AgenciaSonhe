package com.agenciasonhe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenciasonhe.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
