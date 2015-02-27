public class Polynomial {

	/**
	 * Test class for evaluating a polynomial
	 * using the normal method and Horner's rule.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int number = 61;
		int xValue = 4;
		int degree[] = new int[number];
		int coeffNormal[] = new int[number];
		int coeffHorner[] = new int[number];

		/*
		 * int[] degree = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }; int[]
		 * coeffNormal = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1 }; int[] coeffHorner
		 * = { 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		 */

		for (int i = 0; i < number; i++) {
			degree[i] = number - 1 - i;
			coeffNormal[i] = number - 1 - i;
		}
		coeffNormal[number - 1] = 1;
		coeffHorner[0] = 0;

		for (int i = 1; i < number; i++) {
			coeffHorner[i] = i;
		}
		coeffHorner[0] = 1;

		System.out.println("Sending ");
		for (int temp : degree) {
			System.out.print(temp + ", ");
		}

		System.out.println("");
		for (int temp : coeffNormal) {
			System.out.print(temp + ", ");
		}

		System.out.println("");
		for (int temp : coeffHorner) {
			System.out.print(temp + ", ");
		}

		PolynomialValue p1 = new PolynomialValue();
		long before = System.nanoTime();
		long answer = p1.getValue(coeffNormal.length, xValue, degree,
				coeffNormal);
		long after = System.nanoTime();
		long time = after - before;
		
		System.out.println("");
		System.out.println("Total time: " + time);
		
		System.out.println("Value of Normal method at x = " + xValue + " is "
				+ answer);
		
		System.out.println("");
		before = System.nanoTime();
		long answer2 = p1.hornerRule(degree, coeffHorner, xValue);
		after = System.nanoTime();
		time = after - before;
		System.out.println("Total time: " + time);
		
		System.out.println("Value of Horner method at x = " + xValue + " is "
				+ answer2);

		// p1.checkZero(degree);
	}
}
