package com.leonelbg.sistemaventa.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonelbg.sistemaventa.models.Categoria;
import com.leonelbg.sistemaventa.service.CategoriaService;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/")
	public List<Categoria> listaCategoria() {
		return categoriaService.allCategoria();
	}

	@GetMapping("/{idCategoria}")
	public ResponseEntity<Categoria> verCategoria(@PathVariable Long idCategoria) {
		try {
			Categoria mostrarCategoria = categoriaService.getCategoria(idCategoria);
			return new ResponseEntity<Categoria>(mostrarCategoria, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody Categoria categoria){
		try {
			categoriaService.save(categoria);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/update/{idCategoria}")
	public ResponseEntity<?> update(@RequestBody Categoria categoria, @PathVariable Long idCategoria){
		try {
			Categoria existeCategoria = categoriaService.getCategoria(idCategoria);
			if(existeCategoria != null) {
				categoria.setIdCategoria(idCategoria);
				categoriaService.save(categoria);
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			}
			
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<?> delete(@PathVariable Long idCategoria){
		try {
			categoriaService.delete(idCategoria);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/validarnombre/{nombre}")
	public ResponseEntity<Categoria> verificarNombreCategoria(@PathVariable String nombre){
		Categoria categoria = categoriaService.validarPorNombre(nombre);
		if(categoria != null) {
			return new ResponseEntity<Categoria>(categoria,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
