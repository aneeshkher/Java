package com.ip.rtt;

public class RoundTripTime {
	public int calculateRTT(double rj, int bj, double alpha) {
		int counter = 0;
		while (rj <= 499) {
			rj = alpha * rj + (1 - alpha) * bj;
			counter = counter + 1;
			System.out.println("Rj = " + rj);
		}
		return counter;
	}
}
