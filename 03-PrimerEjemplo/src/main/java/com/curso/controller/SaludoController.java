package com.curso.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SaludoController {
	//localhost:8080/saludo
	@GetMapping(value = "saludo", produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar() {
		return "Hola desde Spring Boot";
	}
	
	//localhost:8080/saludo/pepito       --> localhost:8080/saludo/{x}
	
		@GetMapping(value="saludo/{x}", produces=MediaType.TEXT_PLAIN_VALUE)
		public String saludar(@PathVariable("x") String a) {
			return "Hola desde Spring Boot " + a;
			
		}
	

		//localhost:8080/saludo/pepito/grillo     --> localhost:8080/saludo/{x}/{y}
		
			@GetMapping(value="saludo/{x}/{y}", produces=MediaType.TEXT_PLAIN_VALUE)
			public String saludar(@PathVariable("x") String a,@PathVariable("y") String b) {
				return "Hola desde Spring Boot " + a + " " + b;
				
			}
			
			//localhost:8080/saludo2?x=eva&y=23
			@GetMapping(value="saludo2", produces=MediaType.TEXT_PLAIN_VALUE)
			public String saludar2 (@RequestParam("x") String a, @RequestParam("y") String b) { 
				
				return "Hola " + a + " tienes " + b + " años";
			}
			
//			@GetMapping(value="infocliente",produces=MediaType.TEXT_PLAIN_VALUE)
//			public Info informacion() {
//				return new Info("ana", 33, "ana@gmail.com");
//			}
}
			
