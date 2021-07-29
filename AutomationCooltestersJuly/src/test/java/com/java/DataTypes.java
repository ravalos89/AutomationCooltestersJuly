package com.java;

public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte abc = 127;
		short var = 30000;
		
//		long var2 = 9223372036854775807L;
		
//		int altura = (int) 2.54;
		double altura = 2.54;
		System.out.println(altura);
		
		char letra = '\u00D4';
		System.out.println(letra);
		
		String frase = "Hola";
		String frase2 = "Mundo";
		int frase3 = 4;
		int frase4 = 5;
		
		System.out.println(frase+frase2+frase3+frase4);
		
		System.out.println(frase3+frase4);
		
		boolean isDog = true;
		
		int x = 3;
		int y = 4;
		int suma = x*y;
		System.out.println("La suma es "+ suma);
		
		//UNARIO
		int a = 3;
		a--;
		
		System.out.println("El valor de a es "+ a);
		
		// Relacionales
		int var1 = 3;
		int var2 = 4;
		boolean var3 = false;
		
		if(var1>=var2 || !var3) {
			System.out.println("HERE");
		}
	}

}
