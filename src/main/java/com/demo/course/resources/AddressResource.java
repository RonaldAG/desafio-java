package com.demo.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.course.entities.Address;
import com.demo.course.entities.Person;
import com.demo.course.services.AddressService;

@RestController
@RequestMapping(value = "/addresses")
public class AddressResource {
	
	@Autowired
	private AddressService service;
	
	/**
	 * Metodo para consultar lista de endereços
	 */
	@GetMapping
	public ResponseEntity<List<Address>> findAll(){
		List<Address> people = service.findAll();
		return ResponseEntity.ok().body(people);
		
	}
	
	/**
	 * Metodo para consultar lista de pessoas
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id){
		Address address = service.findById(id);
		return ResponseEntity.ok().body(address);
	}
	
	/**
	 * Insere um novo endereço no banco de dados
	 */
	@PostMapping
	public ResponseEntity<Address> insert (@RequestBody Address address){
		address = service.insert(address);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(address.getId()).toUri();
		return ResponseEntity.created(uri).body(address);
	}
}
