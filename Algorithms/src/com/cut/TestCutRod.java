package com.cut;

import java.util.ArrayList;

public class TestCutRod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] a = new int[]{0,1,5,8,9,10,17,17,20,24,30};

		ArrayList<Integer> prices = new ArrayList<Integer>();

		prices.add(1);
		prices.add(1);
		prices.add(5);
		prices.add(8);
		prices.add(9);
		prices.add(10);
		prices.add(17);
		prices.add(17);
		prices.add(20);
		prices.add(24);
		prices.add(30);
		prices.add(35);
		prices.add(38);
		prices.add(41);
		prices.add(42);
		prices.add(50);
		prices.add(53);
		prices.add(57);
		prices.add(59);
		prices.add(60);
		prices.add(61);
		prices.add(62);
		prices.add(64);
		prices.add(67);
		prices.add(68);
		prices.add(70);
		prices.add(71);

		/*for (int i : prices) {
			System.out.println(i);
		}*/
		// CutRod c1 = new CutRod();

		// int maxValue = c1.cutRod(prices, 10);

		CRod c1 = new CRod();
		int maxValue = c1.cutRod(prices,16);
		System.out.println("Max Value: " + maxValue);
		int count = c1.count;
		System.out.println("Function calls: " + count);
	}
}

class CRod {
	public int q;
	public int count;
	
	public CRod() {
		count = 0;
	}
	
	public int cutRod(ArrayList<Integer> p, int n) {
		count++;
		//System.out.println("Received value of n as: " + n);
		//System.out.println("Received ArrayList: " + p);
		if (n == 0) {
			return 0;
		}
		q = -10000;
		for (int i = 1; i < n + 1; i++) {
			//System.out.println("Inside for loop. n = " + n + ". i = " + i + ". q = " + q);
			q = Math.max(q, p.get(i) + cutRod(p, n - i));
			//System.out.println("Q = " + q);
		}
		//System.out.println("Returning Q: " + q);
		return q;
	}
}
