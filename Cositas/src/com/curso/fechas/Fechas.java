package com.curso.fechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Fechas {
	public static void main(String[] args) {
		//Fecha HOY
		LocalDate hoy = LocalDate.now();
		System.out.println("La fecha actual es " + hoy);
		// Año  Mes  Dia
		int year = hoy.getYear();
		int month = hoy.getMonthValue();
		int day = hoy.getDayOfMonth();
		
		//Año bisiesto hoy.isLeapYear();
		
		
		//Fecha Concreta
		LocalDate fechaConcreta = LocalDate.of(2024, 06,25);
		System.out.println(fechaConcreta);
		
	/*	LocalTime
		LocalDateTime
		*/
		
		LocalTime horaActual = LocalTime.now();
		System.out.println(horaActual);
		
		
		LocalDateTime fechaHoraActual = LocalDateTime.now();
		System.out.println(fechaHoraActual);
		
		
		
	}

}
