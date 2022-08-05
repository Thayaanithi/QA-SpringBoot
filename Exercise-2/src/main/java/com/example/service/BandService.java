package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.exception.BandNotFoundException;
import com.example.persistance.domain.Band;
import com.example.persistance.repo.BandRepo;
import com.example.rest.dto.BandDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BandService {
	
	private BandRepo repo;
	private ModelMapper mapper;
	
	private BandDTO maptoDTO(Band band) {
		return this.mapper.map(band, BandDTO.class);
	}

	public BandDTO addBand(Band band) {
		Band saved = this.repo.save(band);
		return this.maptoDTO(saved);
	}
	
	public List<BandDTO>getAllBand(){
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public BandDTO updateband (Long id, Band band) {
		Optional <Band> tempBand = Optional.of(this.repo.findById(id).orElseThrow(BandNotFoundException::new));
		Band existing = tempBand.get();
		existing.setName(band.getName( ));
		existing.setMusicians(band.getMusicians());
		Band updated = this.repo.save(existing);
		return this.maptoDTO(updated);
	}
	
	public boolean deleteBand(Long id) {
		this.repo.findById(id).orElseThrow(BandNotFoundException::new);
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	
	public BandDTO listbandbyId(Long id) {
		Band found = this.repo.findById(id).orElseThrow(BandNotFoundException::new);
		return this.maptoDTO(found);
	}
	
	public BandDTO listbandbyName(String name) {
		Band found = this.repo.bandByName(name).orElseThrow(BandNotFoundException::new);
		return this.maptoDTO(found);
	}
	
}
