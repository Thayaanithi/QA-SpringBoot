package com.example.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistance.domain.Band;
import com.example.persistance.domain.Musician;
@RestController
public class MusicianController {
	public List<Musician>list =new ArrayList();
	
	@GetMapping("/listmusician")
	public List<Musician> listmusician() {
		return this.list;
	
}
}
	