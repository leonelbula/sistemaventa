package com.leonelbg.sistemaventa.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonelbg.sistemaventa.models.Producto;
import com.leonelbg.sistemaventa.service.ProductoService;

@RestController
@RequestMapping("api/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/")
	public List<Producto> listaProducto() {
		return productoService.AllProducto();
	}

	@GetMapping("/{idproducto}")
	public ResponseEntity<Producto> getProducto(@PathVariable Long idproducto) {
		try {
			Producto producto = productoService.getProducto(idproducto);
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Producto producto) {
		try {
			productoService.save(producto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update/{idproducto}")
	public ResponseEntity<?> update(@RequestBody Producto producto, @PathVariable Long idproducto) {
		try {
			Producto productoExiste = productoService.getProducto(idproducto);
			if (productoExiste != null) {
				producto.setIdProducto(idproducto);
				productoService.save(producto);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping("/delete/{idproducto}")
	public ResponseEntity<?> delete(@PathVariable Long idproducto){
		try {
			productoService.delete(idproducto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/validarcodigo/{codigo}")
	public ResponseEntity<Producto> validarCodigo(@PathVariable String codigo){
		try {
			Producto producto = productoService.validarCodigo(codigo);
			if(producto != null) {
				return new ResponseEntity<Producto>(producto, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
