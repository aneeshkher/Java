package com.palindrome;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
		HashMap<Character,Integer> charHash = new HashMap<Character,Integer>();
		char temp;
		int count, oddCharacters;
		/*for (int i = 0; i < inputString.length(); i++) {
			count = 0;
			temp = inputString.charAt(i);
			for (int j = 0; j < inputString.length(); j++) {
				if (inputString.charAt(j) == temp) {
					count++;
				}
			}
			charHash.put(temp,count);
		}*/
		
		for (int i = 0; i < inputString.length(); i++) {
			temp = inputString.charAt(i);
			if (charHash.containsKey(temp)) {
				charHash.put(temp, charHash.get(temp) + 1);				
			} else {
				charHash.put(temp, 1);
			}
		}
		
		oddCharacters = 0;
		for (Map.Entry<Character, Integer> entry : charHash.entrySet()) {
			count = 1;
			temp = entry.getKey();
			count = entry.getValue();
			if (count % 2 == 1) {
				oddCharacters++;
			}
			//System.out.println("Character: " + temp + " -> " + count);
		}
		
        String ans;
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        if (oddCharacters > 1) {
        	ans = "NO";
        } else {
        	ans = "YES";
        }
        //System.out.println("Odd character count: " + oddCharacters);
        System.out.println(ans);
        myScan.close();
	}

}
