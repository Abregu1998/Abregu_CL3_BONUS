package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query("Select a from Cliente a where nombre like :fil")
	public abstract List<Cliente> listaClientePorNombreLike(@Param("fil") String filtro);

	public abstract List<Cliente> findByDni(String dni);
	//public abstract List<Cliente> findByDniAndIdClienteNot(String dni, Integer id_cliente);
	
}
