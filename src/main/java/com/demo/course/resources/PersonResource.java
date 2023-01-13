package com.demo.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.course.entities.Address;
import com.demo.course.entities.Person;
import com.demo.course.services.PersonService;

@RestController
@RequestMapping(value = "/people")
public class PersonResource {
	
	@Autowired
	private PersonService service;
	
	/**
	 * Consulta lista de pessoas
	 */
	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		List<Person> people = service.findAll();
		return ResponseEntity.ok().body(people);
		
	}
	
	/**
	 * Busca pessoa por ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id){
		Person person = service.findById(id);
		return ResponseEntity.ok().body(person);
	}
	
	/**
	 * 
	 * Retorna todos os endereços da pessoa
	 */
	@GetMapping(value = "/{id}/addresses")
	public ResponseEntity<List<Address>> findAllAddressesById(@PathVariable Long id){
		List<Address> addresses = service.findById(id).getAddress();
		return ResponseEntity.ok().body(addresses);
	}
	
	/**
	 * Insere uma nova pessoa no banco de dados
	 */
	@PostMapping
	public ResponseEntity<Person> insert (@RequestBody Person person){
		person = service.insert(person);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(person.getId()).toUri();
		return ResponseEntity.created(uri).body(person);
	}
	
	/**
	 * Altera dados de um usuário
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person){
		person = service.update(id, person);
		return ResponseEntity.ok().body(person);
	}
}
