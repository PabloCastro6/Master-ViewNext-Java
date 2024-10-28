package com.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexController {
	
	@GetMapping(value="/")
	public String index() {
		return "index";
		
	}
	
	@GetMapping(value="/pag2") //Rutas que voy a usar en la URL
	public String mostrarPagina2( ) {
		return "pagina2";
	}

}

/*@Controller
public class IndexController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
		
	}
	
	@RequestMapping(value="/pag2", method=RequestMethod.GET) //Rutas que voy a usar en la URL
	public String mostrarPagina2( ) {
		return "pagina2";
	} */
