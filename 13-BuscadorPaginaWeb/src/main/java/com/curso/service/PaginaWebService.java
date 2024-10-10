package com.curso.service;

import java.util.List;
import java.util.stream.Collectors;

import com.curso.modelo.PaginaWeb;

public class PaginaWebService {
	List<PaginaWeb> paginas = List.of(new PaginaWeb("https://www.pccomponentes.com/dias-naranjas", "Tecnología", "Una página sobre tecnología"),
			new PaginaWeb("https://www.hellofresh.es/recipes/recetas-caseras", "Comida", "Una página sobre comida"),
			new PaginaWeb("https://elpais.com/", "Noticias", "Una página sobre noticias"));
			
			



	public PaginaWeb buscarPorTematica(String tematica) {
        return paginas.stream()
            .filter(p -> p.getTematica().equalsIgnoreCase(tematica))
            .findFirst()  // Buscar la primera coincidencia
            .orElse(null);  // Si no hay coincidencias, retorna null
    }
}
