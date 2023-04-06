package com.leonelbg.sistemaventa.service;

import java.util.List;

import com.leonelbg.sistemaventa.models.Cliente;

public interface ClienteService {
	
	public List<Cliente> allCliente();
	
	public Cliente getCliente(Long idCliente);
	
	public void save(Cliente cliente);
	
	public void delete(Long idCliente);
	
	public Cliente validarNit(String nit);
}
