package com.example.personRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.model.Person;

@Repository
@EnableJpaRepositories
public interface PersonRepo extends JpaRepository<Person,Long>{
@Query("select p from Person p where p.name = ?1")
List<Person> findPersonbyName(String name);
}
