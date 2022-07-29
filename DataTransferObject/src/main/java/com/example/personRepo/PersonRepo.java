package com.example.personRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.model.Person;

@Repository
@EnableJpaRepositories
public interface PersonRepo extends JpaRepository<Person,Integer>{

}
