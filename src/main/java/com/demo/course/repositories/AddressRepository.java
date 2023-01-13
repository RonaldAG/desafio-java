package com.demo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.course.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
