package com.leonelbg.sistemaventa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonelbg.sistemaventa.models.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria, Long>{

}
