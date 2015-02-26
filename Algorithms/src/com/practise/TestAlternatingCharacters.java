package com.practise;

import java.util.Scanner;

public class TestAlternatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * for (String temp : args) {
		 * System.out.println("Command line argument: " + temp); }
		 */

		int temp, j, count;
		char first;
		// String tempString;

		String s1[] = new String[100000];
		Scanner scan = new Scanner(System.in);

		int testCases = scan.nextInt();
		System.out.println("");
		// System.out.println("Scanned integer: " + testCases);

		System.out.println("");
		scan.nextLine();

		/*
		 * s1[0] = scan.nextLine(); System.out.println("Scanned string: " +
		 * s1[0]);
		 * 
		 * System.out.println(""); s1[1] = scan.nextLine();
		 * System.out.println("Scanned string: " + s1[1]);
		 */

		for (int i = 0; i < testCases; i++) {
			count = 0;
			s1[i] = scan.nextLine();
			//temp = s1[i].length();
			/*
			 * System.out.println("Scanned String: " + s1[i] + " of length: " +
			 * temp);
			 */
			
		}
		for (int i = 0; i < testCases; i++) {
			count = 0;
			for (j = 1; j < s1[i].length(); j++) {
				if (s1[i].charAt(j) == s1[i].charAt(j-1)) {
					count++;
				}
			}
			System.out.println(count);
		}

		scan.close();
	}

}
