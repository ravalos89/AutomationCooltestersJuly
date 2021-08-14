package com.poo;

public class Main {

	public static void main(String[] args) {
		
		// Objeto
		Perro perro = new Perro(4, "Dorado", "Grande", "Golden Labrador");		
		System.out.println("Mi perro es de raza "+ perro.getRaza());
		
		Perro perro2 = new Perro("Blanco", "Chico", "Chihuahua cabeza de manzana");
		perro2.setRaza("Unknown");
		System.out.println("Mi perro es de raza "+ perro2.getRaza());
		
		Perro perro3 = new Perro("Blanco", "Chico", "Chihuahua golden");
		perro3.setNumPatas(10000);
		System.out.println("Mi perro es de raza "+ perro3.getRaza() + " y mi perro tiene "+ perro3.getNumPatas());
	}

}
