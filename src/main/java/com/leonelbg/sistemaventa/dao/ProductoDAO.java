package com.leonelbg.sistemaventa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonelbg.sistemaventa.models.Producto;

public interface ProductoDAO extends JpaRepository<Producto, Long>{
	
	public List<Producto> findByCodigo(String codigo);

}
