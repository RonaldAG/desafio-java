package com.demo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.course.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
