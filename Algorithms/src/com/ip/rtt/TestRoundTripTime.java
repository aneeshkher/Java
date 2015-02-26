package com.ip.rtt;

public class TestRoundTripTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoundTripTime r1 = new RoundTripTime();
		int iterations = r1.calculateRTT(150, 500, 0.9);
		System.out.println("Iterations: " + iterations);
	}

}
