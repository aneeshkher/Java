package com.exp.recurse;

public class TestRecurseExponent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int base = 3;
		int power = 33;
		GetExponentProduct g1 = new GetExponentProduct();
		long before1 = System.nanoTime();
		long answer = g1.multiply(base, power);
		long after1 = System.nanoTime() - before1;

		System.out.println("");
		long before2 = System.nanoTime();
		long answer1 = g1.normalExponent(base, power);
		long after2 = System.nanoTime() - before2;

		System.out.println("");
		System.out.println("Answer resurse is: " + answer + ". Time is: "
				+ after1);
		System.out.println("Answer normal is: " + answer1 + ". Time is: "
				+ after2);
		
		GetExponentProduct g2 = new GetExponentProduct();
		g2.printFormula(33);
		
		System.out.println(g1.hashCode());
		System.out.println(g2.hashCode());
		
	}

}
