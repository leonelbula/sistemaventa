package com.leonelbg.sistemaventa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.leonelbg.sistemaventa.dao.ProductoDAO;
import com.leonelbg.sistemaventa.models.Producto;

public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoDAO productoDao;

	@Override
	public List<Producto> AllProducto() {
		return productoDao.findAll();
	}

	@Override
	public Producto getProducto(Long idProducto) {
		return productoDao.findById(idProducto).get();
	}

	@Override
	public void save(Producto producto) {
		productoDao.save(producto);
	}

	@Override
	public void delete(Long idProducto) {
		productoDao.deleteById(idProducto);
		
	}

	@Override
	public Producto validarCodigo(String codigo) {
		return productoDao.findByCodigo(codigo).get(0);
	}
	
	

}
