package com.demo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.course.entities.Address;
import com.demo.course.entities.Person;
import com.demo.course.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> findAll(){
		return addressRepository.findAll();
	}
	
	public Address findById(Long id) {
		Optional<Address> address = addressRepository.findById(id);
		return address.get();
	}
	
	public Address insert(Address address) {
		return addressRepository.save(address);
	}
}
