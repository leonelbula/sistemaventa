package com.leonelbg.sistemaventa.service;

import java.util.List;

import com.leonelbg.sistemaventa.models.Producto;

public interface ProductoService {
	
	public List<Producto> AllProducto();
	
	public Producto getProducto(Long idProducto);
	
	public void save(Producto producto);
	
	public void delete(Long idProducto);
	
	public Producto validarCodigo(String codigo);

}
