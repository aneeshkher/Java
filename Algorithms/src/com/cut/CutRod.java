package com.cut;

import java.util.ArrayList;

public class CutRod {
	public int cutRod(ArrayList<Integer> p, int n) {
		System.out.println("Received value of n as: " + n);
		System.out.println("Received ArrayList: " + p); 
		if (n == 0) {
			return 0;
		}
		int q = -1;
		for (int i = 1; i <= n; i++) {
			q = Math.max(q, p.get(i) + cutRod(p, n - i));
			System.out.println("Q = " + q);
		}
		System.out.println("Returning Q: " + q);
		return q;
	}
}
