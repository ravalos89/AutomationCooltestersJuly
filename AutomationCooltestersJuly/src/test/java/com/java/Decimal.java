package com.java;

public class Decimal {

	public static void main(String[] args) {

		System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123));

	}

	public static boolean areEqualByThreeDecimalPlaces(double x, double y) {

		x = x * 1000;
		y = y * 1000;

		int converterX = (int) x;
		int converterY = (int) y;

		if (converterX == converterY) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean hasEqualSum(int num1, int num2, int num3) {
		
		return (num1 + num2 == num3) ? true : false;
//		int suma = num1 + num2;
//		if (suma == num3) {
//			return true;
//		} else
//			return false;
	}
}
