package com.curso.service;

import java.util.List;

import com.curso.formacion.model.Formacion;

public interface FormacionService {
	 List<Formacion> nuevaFormacion(Formacion formacion);
	 
	 // Método para obtener la lista de formaciones
	    List<Formacion> obtenerListaFormaciones();

}
