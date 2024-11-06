package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.modelo.Ejemplar;
@Service
public class EjemplarServiceImpl implements EjemplarService{
	@Autowired
	RestTemplate template;
	private String url="http://localhost:8080/";
	
	@Override
	public List<Ejemplar> nuevoEjemplar(Ejemplar ejemplar) {
		template.postForLocation(url+"libros", ejemplar);
		return Arrays.asList(template.getForObject(url+"libros", Ejemplar[].class));
	}

}
