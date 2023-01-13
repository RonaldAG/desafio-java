package com.demo.course.config;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.demo.course.entities.Address;
import com.demo.course.entities.Person;
import com.demo.course.entities.enums.AddressStatus;
import com.demo.course.repositories.AddressRepository;
import com.demo.course.repositories.PersonRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private PersonRepository personRepository;
	

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Person person = new Person(null, "Ronald", Date.valueOf("2003-04-15"));
		Person person2 = new Person(null, "Agatha", Date.valueOf("2003-05-05"));
		
		
		Address address = new Address(null, "A", "091", 70l, "SAO PAULO", AddressStatus.ENDERECO_PRINCIPAL,person);
		Address address2 = new Address(null, "b", "092", 72l, "Osasco", AddressStatus.ENDERECO_SECUNDARIO,person);
		Address address3 = new Address(null, "c", "093", 74l, "Minas", AddressStatus.ENDERECO_SECUNDARIO,person);
		Address address4 = new Address(null, "d", "094", 76l, "Bahia", AddressStatus.ENDERECO_PRINCIPAL,person2);
		Address address5 = new Address(null, "e", "095", 78l, "BH", AddressStatus.ENDERECO_SECUNDARIO,person2);
		
		personRepository.saveAll(Arrays.asList(person, person2));
		addressRepository.saveAll(Arrays.asList(address, address2, address3, address4, address5));
		
	}

}
