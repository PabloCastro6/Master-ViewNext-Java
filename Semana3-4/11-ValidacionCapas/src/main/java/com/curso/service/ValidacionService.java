package com.curso.service;

import java.util.List;

import com.curso.modelo.Perfil;

public class ValidacionService {
	List<Perfil> perfil = List.of(new Perfil("admin", "1234", "admin@gmail.com",45),
				new Perfil("user", "5678", "user@gmail.com",45),
				new Perfil("main", "8901", "main@gmail.com",45),
				new Perfil("otro", "3456", "otro@gmail.com",45));
	
	
	public Perfil autenticar(String nombre, String pass) {
		 return perfil.stream()
		            .filter(x -> x.getNombre().equals(nombre) && x.getPassword().equals(pass))
		            .findFirst()
		            .orElse(null);
		
	}

}
