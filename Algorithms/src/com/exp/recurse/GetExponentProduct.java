package com.exp.recurse;


import java.util.HashMap;


public class GetExponentProduct {

	private long answer;

	public long multiply(int base, int pow) {

		int indexCopy;
		if (pow == 1) {
			return base;
		} else if (pow == 0) {
			return 1;
		} else {
			indexCopy = pow;
			double a = Math.floor(pow / 2);
			pow = (int) a;
			answer = multiply(base, pow);
			System.out.print("test ");
			if (indexCopy % 2 == 1) {
				return answer * answer * base;
			} else {
				return answer * answer;
			}
		}
	}

	public long normalExponent(int base, int index) {
		answer = 1;
		if (index == 1) {
			return base;
		} else if (index == 0) {
			return 0;
		} else {
			for (int i = 0; i < index; i++) {
				System.out.print("test1 ");
				answer = answer * base;
			}
		}
		return answer;
	}

	public void printFormula(int index) {
		// double a = Math.floor(index/2);
		int value;
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		for (int i = 2; i <= index; i++) {
			if ((i % 2) == 1) {
				value = hashMap.get((i - 1) / 2) + 2;
				hashMap.put(i, value);
			} else {
				value = hashMap.get(i / 2) + 1;
				hashMap.put(i, value);
			}
		}

		for (java.util.Map.Entry<Integer, Integer> e1 : hashMap.entrySet()) {
			System.out.println("T(" + e1.getKey() + ") = " + e1.getValue());
		}

	}
}
