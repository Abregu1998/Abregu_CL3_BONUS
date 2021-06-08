package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Cliente;
import com.empresa.service.ClienteService;

import lombok.extern.apachecommons.CommonsLog;


@CommonsLog
@RestController
@RequestMapping("/rest/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> lista(){
		log.info(">>> inicio >>> lista ");
		List<Cliente> lstCliente = service.listaCliente();
		return ResponseEntity.ok(lstCliente);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> registra(@RequestBody Cliente obj){
		log.info(">>> inicio >>> registra " + obj.getNombre());
		Cliente objCliente = service.insertaActualizaCliente(obj);
		return ResponseEntity.ok(objCliente);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> actualiza(@RequestBody Cliente obj){
		log.info(">>> inicio >>> actualiza " + obj.getNombre());
		Optional<Cliente> optAlumno =   service.obtienePorId(obj.getId_cliente());
		if (optAlumno.isPresent()) {
			Cliente objAlumno = service.insertaActualizaCliente(obj);
			return ResponseEntity.ok(objAlumno);
		}else {
			log.info(">>> No existe el cliente " + obj.getId_cliente());
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> elimina(@PathVariable("id_cliente") int id_cliente){
		log.info(">>> inicio >>> elimina " + id_cliente);
		Optional<Cliente> optCliente =   service.obtienePorId(id_cliente);
		if (optCliente.isPresent()) {
			service.eliminaCliente(id_cliente);
			return ResponseEntity.ok(optCliente.get());
		}else {
			log.info(">>> No existe el cliente " + id_cliente);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{dni}")
	public ResponseEntity<List<Cliente>> listaPorDni(@PathVariable("dni") String dni){
		log.info(">>> inicio >>> listaPorDni ");
		List<Cliente> lstCliente = service.listaPorDni(dni);
		return ResponseEntity.ok(lstCliente);
	}
}
