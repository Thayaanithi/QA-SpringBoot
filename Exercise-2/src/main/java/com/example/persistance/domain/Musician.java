package com.example.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Musician {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 0, max = 55)
	private String name;

	@Min(0)
	@Max(12)
	private Integer strings;

	@NotNull
	private String type;

	@ManyToOne
	private Band band;

	public Musician(Long id, String name, Integer strings, String type, Band band) {
		super();
		this.id = id;
		this.name = name;
		this.strings = strings;
		this.type = type;
		this.band = band;
	}

	public Musician() {
		super();
		
	}

}