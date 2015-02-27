package com.denom;



/**
 * @author Aneesh
 * Test class for sending input to methods
 * Actual mathod implementations in Denominations.java
 */
public class TestDenominations {

	private static TestDenominations obj;

	TestDenominations() {
		obj = this;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestDenominations();
		DenominationsOne d111 = obj.new DenominationsOne();
		d111.testing();
		int number = 61127;
		Denominations d1 = new Denominations();
		Denominations d2 = new Denominations();
		Denominations d3 = new Denominations();
		System.out.println("--Constant time non recursive--");
		d2.calcuateConstant(number);
		System.out.println("--Third method--");
		d3.calculateRefined(number, 50);
		System.out.println("--Recursive--");
		d1.calculate(number);
		// d1.printCoinCount();
	}

	class DenominationsOne {

		void testing() {
			System.out.println("testing");
		}
	}

}
