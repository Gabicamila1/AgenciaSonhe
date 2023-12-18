package com.agenciasonhe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenciasonhe.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
