package com.example.rest.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistance.domain.Musician;
import com.example.rest.dto.MusicianDTO;
import com.example.service.MusicianService;

import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor

public class MusicianController {
	
	private MusicianService service;
	
	@PostMapping ("/addmusician")
	public MusicianDTO addmusician(@RequestBody Musician musician) {
		return service.addMusician(musician);
			}
	
	@GetMapping ("/allMusician")
	public List <MusicianDTO> getallmusician(){
		return service.getAllMusicians();
			
		}
	
	@PutMapping ("/updateMusician/{id}")
	public MusicianDTO updateMusician(@PathVariable Long id, @RequestBody Musician musician) {
		return service.updateMusician(id, musician);
	}
	
	@DeleteMapping("/deleteMusician/{id}")
	public Boolean deleteMusician(@PathVariable Long id) {
		return service.deleteMusician(id);
	}
	
	@GetMapping("/listMusicianById")
	public MusicianDTO listmusicianById(@PathParam("id") Long id) {
		return service.listMusiciansById(id);
	}
	
		@GetMapping("/listMusicianByName")
		public List<MusicianDTO> listMusicianByName(@PathParam("name") String name) {
			return service.listMusicianByName(name);
		}
	
}
