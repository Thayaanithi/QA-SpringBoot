package com.example.persistance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.persistance.domain.Musician;

@Repository
@EnableJpaRepositories
public interface MusicianRepo extends JpaRepository<Musician, Long>{

	@Query("select m from Musician m where m.name=?1")
	List<Musician> musicianByName(String name);
}
