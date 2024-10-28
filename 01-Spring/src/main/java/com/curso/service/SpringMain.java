package com.curso.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		
		//Crear un contexto
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext();
		
		//Registrar los fihceros de anotaciones 
		contexto.register(SpringConfigurador.class);
		
		//Refrescar el contexto
		contexto.refresh();
		
		Servicio servicio = contexto.getBean(Servicio.class);
		System.out.println(servicio.mensaje());
		
		contexto.close();
	}

}
