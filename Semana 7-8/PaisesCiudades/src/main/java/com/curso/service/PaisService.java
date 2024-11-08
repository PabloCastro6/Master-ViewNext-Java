package com.curso.service;

import java.util.List;

import com.curso.model.Pais;

public interface PaisService {
	List<Pais> getAllCountries();
	Pais createCountry(Pais country);
}
