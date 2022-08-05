package com.example.persistance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.persistance.domain.Band;

@Repository
@EnableJpaRepositories
public interface BandRepo extends JpaRepository<Band, Long> {
@Query("select b from Band b where b.name=?1")
List <Band> bandByName(String name);
}
