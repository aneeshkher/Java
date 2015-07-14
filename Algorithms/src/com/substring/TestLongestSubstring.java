package com.substring;

import java.util.ArrayList;

public class TestLongestSubstring {
	
	static int count;
	static int longest;
	static ArrayList<Character> c = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * String a = "ABCCBGD"; String b = "BABCGDG";
		 * longestString(a.substring(0, 0), b.substring(0, 0));
		 */
		
		count = 0;
		longest = -1;
		
		String a = "SQAPRHFYYTNBMDALNM";
		String b = "PRHFYYTSGDDALNCBS";
		/*String a = "QLXCVWTRQPZFDCUYBY";
		String b = "SXCVWTRQBFDCUYAY";*/
		longSubstring(a, b);
		//longestComSubstring(a, b);
		//longestString(a, b);
	}
	
	static void longSubstring (String a, String b) {
		int lenA = a.length();
		int lenB = b.length();
		int maxCount = -1;
		int row = -1;
		int column = -1;
		
		int[][] count = new int[lenA + 1][lenB + 1];
		//int[][] common = new int[lenA + 1][lenB + 1];
		
		for (int i = 0; i < lenA; i++) {
			for (int j = 0; j < lenB; j++) {
				if (a.charAt(i) == b.charAt(j)) {
					if (count[i][j] == 0) {
						count[i + 1][j + 1] = 1;
					} else {
						count[i + 1][j + 1] = count[i][j] + 1;
					}
					if (maxCount < count[i + 1][j + 1]) {
						maxCount = count[i + 1][j + 1];
						row = i + 1;
						column = j + 1;
					}
				}
			}
		}
		
		for (int i = 0; i < lenA + 1; i++) {
			for (int j = 0; j < lenB + 1; j++) {
				System.out.print(count[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("Max count = " + maxCount + ". Row/Column = " + row + "/" + column);
		System.out.println("");
		for (int i = row-maxCount; i < row; i++) {
			System.out.print(a.charAt(i));
		}
	}
	
	static void longestComSubstring (String a, String b) {
		int lenA = a.length();
		int lenB = b.length();
		int count = 0;
		int maxCount = -1;
		System.out.println("Lengths: " + lenA + " and " + lenB);
		int[][] aux = new int[lenA + 1][lenB + 1];
		
		for (int i = 0 ; i <= lenA ; i++) {
			for (int j = 0 ; j <= lenB ; j++) {
				aux[i][j] = -1;
			}
		}
		
		/*for (int i = 0; i <= lenA; i++) {
			for (int j = 0; j <= lenB; j++) {
				System.out.print(aux[i][j] + "   ");
			}
			System.out.println("");
		}*/
		
		for (int i = 0 ; i < lenA ; i++) {
			for (int j = 0 ; j < lenB ; j++) {
				if (a.charAt(i) == b.charAt(j)) {
					aux[i + 1][j + 1] = 1;
					if (aux[i][j] == 1) {
						count++;
						c.add(a.charAt(i));
					} else {
						c.add(a.charAt(i));
						count = 1;
					}
					if (count > maxCount) {
						maxCount = count;
					}
				} else {
					aux[i + 1][j + 1] = 0;
				}
			}
		}
		
		count = 0;
		maxCount = -1;
		for (int i = 1; i <= lenA; i++) {
			for (int j = 1; j <= lenB; j++) {
				System.out.print(aux[i][j] + " ");
				if (aux[i][j] == 1) {
					if (aux[i - 1][j - 1] == 1) {
						count++;
					} else {
						count = 1;
					}
					if (count > maxCount) {
						maxCount = count;
					}
				}
			}
			System.out.println("");
		}
		
		System.out.println("Longest common substring: " + maxCount);
	}
	
	static void longestString(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();

		
		if ((lenA == 0) || (lenB == 0)) {
			
		} else {
			System.out.println("Received: " + a + " " + b);
			if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
				count++;
				if (count > longest) {
					longest = count;
				}
				longestString(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1));
			} else {
				count = 0;
				longestString(a, b.substring(0, b.length() - 1));
				longestString(a.substring(0, a.length() - 1), b);
			}
		}
		//System.out.println(lenA + " " + lenB);
	}
}
