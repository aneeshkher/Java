package com.denom;

import java.util.ArrayList;


/**
 * @author Aneesh
 * Three methods for calculating the minimum number of coins
 * given the denominations and the cent value.
 */
public class Denominations {
	int coinNumber, coinCount, arrayPointer;
	ArrayList<Integer> denom = new ArrayList<Integer>();
	int den;
	int size;
	int callCount;

	public Denominations() {
		coinNumber = 0;
		callCount = 0;
		coinCount = 0;
		arrayPointer = 0;
		denom.add(0, 50);
		denom.add(1, 25);
		denom.add(2, 10);
		denom.add(3, 5);
		denom.add(4, 1);
	}

	//Recursive method running in O(n)
	public void calculate(int number) { // Change to return VOID
		size = denom.size();
		// System.out.println("Array size is: " + size);
		if (number == 0) {
			System.out.println("Coins for " + denom.get(0) + " are "
					+ coinNumber);
			System.exit(0);
		} else {
			// int[] denom = new int[] { 50, 25, 10, 5, 1 };
			for (int i = 0; i < size; i++) {
				den = denom.get(0);
				if (number >= den) {
					coinNumber++;
					callCount++;
					// System.out.println("Calling recursively number " +
					// callCount);
					calculate(number - den);
					System.out.println("After returning!");
				} else {
					if (coinNumber != 0) {
						System.out.println("Coins for " + den + " are "
								+ coinNumber);
					}
					denom.remove(0);
					coinNumber = 0;
				}
			}
			System.out.println("Last statement in else");
		}
	}

	// Better recursive method running in O(n)
	public void calculateRefined(int number, int denomination) {
		int temp;
		if (number == 0) {
			temp = denom.get(arrayPointer);
			System.out.println("Coins for " + temp + " are " + coinCount);
		} else {
			if (number >= denomination) {
				coinCount++;
				calculateRefined(number - denomination, denomination);
			} else {
				temp = denom.get(arrayPointer);
				if (coinCount != 0){
					System.out.println("Coins for " + temp + " are " + coinCount);
				}
				coinCount = 0;
				arrayPointer++;
				den = denom.get(arrayPointer);
				calculateRefined(number, den);
			}
		}
	}

	// Non recursive method running in O(1)
	public void calcuateConstant(int num) {
		/*
		 * denom.add(0, 50); denom.add(1, 25); denom.add(2, 10); denom.add(3,
		 * 5); denom.add(4, 1);
		 */
		double temp, number;
		int rem, numCopy;
		int fAnswer;
		numCopy = num;
		number = num / 1.0;
		// System.out.println("Before for loop");
		for (int d : denom) {
			// System.out.println("Denom is: " + d);
			temp = d / 1.0;
			double flr = Math.floor(number / temp);
			rem = numCopy % d;
			numCopy = rem;
			number = numCopy / 1.0;
			fAnswer = (int) flr;
			if (fAnswer != 0) {
				System.out.println("Coins for " + d + " are " + fAnswer);
			}
		}
	}
}
