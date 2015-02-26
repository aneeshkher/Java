package com.factdemo;

public class TestFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long before = System.currentTimeMillis();
		long beforeN = System.nanoTime();
		
		ComputeFactorial f1 = new ComputeFactorial();
		
		long afterN = System.nanoTime();
		long after = System.currentTimeMillis();
		
		long answer = f1.factorial(55);
		
		long timeN = afterN - beforeN;
		long time = after - before;
		System.out.println("Factorial is: " + answer);
		System.out.println("Time taken in mili: " + time);
		System.out.println("TIme taken in nano: " + timeN);
	}

}
