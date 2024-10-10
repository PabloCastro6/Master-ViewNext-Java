package com.curso.service;

import java.util.List;
import java.util.stream.Collectors;

import com.curso.modelo.PaginaWeb;

public class PaginaWebService {


	    private List<PaginaWeb> paginas = List.of(
	        new PaginaWeb("https://www.pccomponentes.com", "Tecnología", "Una página sobre tecnología"),
	        new PaginaWeb("https://www.hellofresh.es", "Comida", "Una página sobre comida"),
	        new PaginaWeb("https://elpais.com", "Noticias", "Una página sobre noticias")
	    );

	    public List<PaginaWeb> buscarPorTematica(String tematica) {
	        return paginas.stream()
	            .filter(p -> p.getTematica().equalsIgnoreCase(tematica))
	            .collect(Collectors.toList());
	    }
	}


