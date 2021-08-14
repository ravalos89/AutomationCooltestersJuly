package com.herencia;

import com.herencia2.Hija;

public class Main {

	public static void main(String[] args) {

		Hijo ricardo = new Hijo(2, "cafes");

		ricardo.personalidad();
		
		Padre hilda = new Padre(2, "Cafes");
		hilda.personalidad();
	}

}
