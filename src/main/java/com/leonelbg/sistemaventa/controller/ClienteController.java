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

import com.leonelbg.sistemaventa.models.Cliente;
import com.leonelbg.sistemaventa.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/")
	public List<Cliente> listarCliente(){
		return clienteService.allCliente();
	}
	
	@GetMapping("/{idcliente}")
	public ResponseEntity<Cliente> getCliente(@PathVariable Long idcliente){
		try {
			Cliente cliente = clienteService.getCliente(idcliente);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Cliente cliente){
		try {
			clienteService.save(cliente);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update/{idcliente}")
	public ResponseEntity<?> update(@PathVariable Long idcliente ,@RequestBody Cliente cliente){
		try {
			cliente.setIdCliente(idcliente);
			clienteService.save(cliente);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{idcliente}")
	public ResponseEntity<?> delete(@RequestBody Long idcliente){
		try {
			clienteService.delete(idcliente);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/validarnit/{nit}")
	public ResponseEntity<Cliente> getCliente(@PathVariable String nit){
		try {
			Cliente cliente = clienteService.validarNit(nit);
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
