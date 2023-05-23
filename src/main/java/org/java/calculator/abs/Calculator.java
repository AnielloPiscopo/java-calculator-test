package org.java.calculator.abs;

public abstract class Calculator {
	public float add(float num1 , float num2) {
		float res = num1 + num2;
		return res;
	}
	
	public float substract(float num1 , float num2) {
		float res = num1 - num2;
		return res;
	}
	
	public float divide(float num1 , float num2) {
		float res = num1 / num2;
		return res;
	}
	
	public float multiply(float num1 , float num2) {
		float res = num1 * num2;
		return res;
	}	
}
