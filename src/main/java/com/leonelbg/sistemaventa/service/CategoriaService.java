package com.leonelbg.sistemaventa.service;

import java.util.List;

import com.leonelbg.sistemaventa.models.Categoria;

public interface CategoriaService {
	
	public List<Categoria> allCategoria();
	
	public Categoria getCategoria(Long idCategoria);
	
	public void save(Categoria categoria);
	
	public void delete(Long idCategoria);

}
