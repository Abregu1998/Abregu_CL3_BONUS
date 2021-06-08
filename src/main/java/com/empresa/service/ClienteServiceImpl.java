package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Cliente;
import com.empresa.repository.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<Cliente> listaCliente() {
		return repository.findAll();
	}

	@Override
	public Cliente insertaActualizaCliente(Cliente obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Cliente> obtienePorId(int id_cliente) {
		return repository.findById(id_cliente);
	}

	@Override
	public void eliminaCliente(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<Cliente> listaClientePorNombreLike(String filtro) {
		return repository.listaClientePorNombreLike(filtro);
	}

	@Override
	public List<Cliente> listaPorDni(String dni) {
		return repository.findByDni(dni);
	}
/*
	@Override
	public List<Cliente> listaPorDni(String dni, int id_cliente) {
		return repository.findByDniAndIdClienteNot(dni, id_cliente);
	}
*/
}
