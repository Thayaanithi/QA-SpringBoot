package com.example.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistance.domain.Band;

@RestController
public class BandController {
public List<Band>list =new ArrayList();

@PostMapping ("/createband")
public void create(@RequestBody Band band) {
	this.list.add(band);
}

@PutMapping ("/updateband/{id}")
public void update (@PathVariable Long id, @RequestBody Band band){
		this.list.remove(id);
		this.list.add(band);
		return this.list.get(id);
	}

@DeleteMapping("/deleteband/{id}")
public void delete(@pathVariable Long id) {
		this.list.remove(id);
	}


@GetMapping("/readband")
public List<Band> read(){
	return this.list;
}





@GetMapping("/listband")
public List<Band> listband() {
	return this.list;
}
}