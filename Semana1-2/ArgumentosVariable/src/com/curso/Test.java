package com.curso;

public class Test {

	public static void main(String[] args) {
	
		Estadistica esta = new Estadistica();
		double r1 = esta.media(1, 2);
		System.out.println(r1);
		
		Estadistica esta2 = new Estadistica();
		System.out.println(esta2.otraMedia(1,2));
		System.out.println(esta2.otraMedia(1,2,3));
	}

}
