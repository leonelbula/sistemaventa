package com.leonelbg.sistemaventa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.leonelbg.sistemaventa.dao.ClienteDAO;
import com.leonelbg.sistemaventa.models.Cliente;

public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteDAO clienteDao;

	@Override
	public List<Cliente> allCliente() {	
		return clienteDao.findAll();
	}

	@Override
	public Cliente getCliente(Long idCliente) {
		return clienteDao.findById(idCliente).get();
	}

	@Override
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
		
	}

	@Override
	public void delete(Long idCliente) {
		clienteDao.deleteById(idCliente);
		
	}

	@Override
	public Cliente validarNit(String nit) {
		// TODO Auto-generated method stub
		return clienteDao.findByNit(nit).get(0);
	}
	
}
