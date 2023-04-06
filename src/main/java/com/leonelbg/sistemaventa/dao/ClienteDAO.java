package com.leonelbg.sistemaventa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonelbg.sistemaventa.models.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Long>{
	
	public List<Cliente> findByNit(String nit);
}
