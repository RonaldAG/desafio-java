package com.demo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.course.entities.Person;
import com.demo.course.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAll(){
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.get();
	}
	
	public Person insert(Person obj) {
		return personRepository.save(obj);
	}
	
	public Person update(Long id, Person obj) {
		Person entity = personRepository.getReferenceById(id);
		updateData(entity, obj);
		return personRepository.save(entity);
	}

	private void updateData(Person entity, Person obj) {
		entity.setNome(obj.getNome());
		entity.setDataNascimento(obj.getDataNascimento());
	}
	
	
}
