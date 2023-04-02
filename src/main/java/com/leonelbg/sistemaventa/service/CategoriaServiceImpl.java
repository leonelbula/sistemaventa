package com.leonelbg.sistemaventa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.leonelbg.sistemaventa.dao.CategoriaDAO;
import com.leonelbg.sistemaventa.models.Categoria;

public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Override
	public List<Categoria> allCategoria() {

		return categoriaDAO.findAll();
	}

	@Override
	public Categoria getCategoria(Long idCategoria) {
		
		return categoriaDAO.findById(idCategoria).get();
	}

	@Override
	public void save(Categoria categoria) {
		
		categoriaDAO.save(categoria);
	}

	@Override
	public void delete(Long idCategoria) {
		
		categoriaDAO.deleteById(idCategoria);
		
	}

	@Override
	public Categoria validarPorNombre(String nombre) {
		
		return categoriaDAO.findByName(nombre);
	}
	
}
