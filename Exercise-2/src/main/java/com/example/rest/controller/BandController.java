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

import com.example.persistance.domain.Band;
import com.example.rest.dto.BandDTO;
import com.example.service.BandService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BandController {
private BandService service;
	
@PostMapping ("/addband")
public BandDTO addband(@RequestBody Band band) {
	return service.addBand(band);
	
}
@GetMapping ("/allband")
public List<BandDTO> getallband(){
	return service.getAllBand();
}

@PutMapping ("/updateband/{id}")
public BandDTO updateband (@PathVariable Long id, @RequestBody Band band){
		return service.updateband(id, band);
	}

@DeleteMapping("/deleteband/{id}")
public boolean deleteband(@PathVariable Long id) {
		return service.deleteBand(id);
	}


@GetMapping("/listbandbyId")
public BandDTO listbandbyId(@PathParam("id") Long id) {
	return service.listbandbyId(id);
}


@GetMapping("/listbandbyName")
public BandDTO listbandbyName(@PathParam("name")String name) {
	return service.listbandbyName(name);
}
}