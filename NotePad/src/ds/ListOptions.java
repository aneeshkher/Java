package ds;

import java.util.HashMap;
import java.util.Scanner;

public class ListOptions {
	public int calculateLength() {
		Node temp = Root.root;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	public void removeDuplicates() {
		HashMap<Integer, Boolean> duplicates = new HashMap<>();
		Node temp = Root.root;
		Node previous = null;
		while (temp != null) {
			if (duplicates.containsKey(temp.data)) {
				previous.next = temp.next;
				temp = temp.next;

			} else {
				duplicates.put(temp.data, true);
				previous = temp;
				temp = temp.next;
			}
		}
	}

	public void getNthNode(int n) {
		Node temp = Root.root;
		int flag = 0;
		for (int i = 1; i < n; i++) {
			temp = temp.next;
			if (temp == null) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			System.out.println(n + " nodes do not exist");
		} else {
			System.out.println("Node number " + n + " is " + temp.data);
		}
	}
	
	public void reversePosition (int m, int n) {
		System.out.println("Reversing list from position "
				+ m + " to " + n);
		
		Node current = Root.root;
		Node previous = null;
		Node before = null;
		int count = 1;
		while (count < m) {
			before = current;
			current = current.next;
			count++;
		}
		Node first = current;
		Node next = current.next;
		
		int temp = n - m + 1;
		for (int i = 0; i < temp; i++) {
			current.next = previous;
			previous = current;
			current = next;
			if (current == null) {
				break;
			}
			next = current.next;
		}
		
		if (first.equals(Root.root)) {
			first.next = current;
			Root.root = previous;
		} else {
			first.next = current;
			before.next = previous;
		}
		
	}

	public void reverseGroup(int k) {
		int count = 0;
		
		Node temp = Root.root;
		while (true) {
			reversePosition(count + 1, count + k);
			for (int i = 0; i < k; i++) {
				temp = temp.next;
				if (temp == null) {
					return;
				}
				count++;
			}
			
		}
	}

	public void rotateList(int k) {
		Node temp = Root.root;
		for (int i = 1; i < k; i++) {
			temp = temp.next;
		}

		System.out.println("temp.data: " + temp.data);

		Node temp2 = temp.next;
		System.out.println("temp2.data: " + temp2.data);
		temp.next = null;
		temp = temp2;
		while (temp2.next != null) {
			temp2 = temp2.next;
		}
		temp2.next = Root.root;
		Root.root = temp;
	}

	public void chooseOption(Scanner scan) {

		System.out.println("Enter your choice:");
		System.out.println("A. Length");
		System.out.println("B. Remove Duplicates");
		System.out.println("C. Get Nth node");
		System.out.println("D. Rotate");
		System.out.println("E. Reverse every k nodes");
		System.out.println("F. Reverse from A to B");
		String option = scan.next();
		switch (option.toUpperCase()) {
		case "A":
			int length = calculateLength();
			System.out.println("Length of list is: " + length);
			// scan.close();
			break;
		case "B":
			removeDuplicates();
			break;
		case "C":
			System.out.println("Enter the number of the node");
			int nth = scan.nextInt();
			getNthNode(nth);
			break;
		case "D":
			System.out.println("Enter the amount by which you "
					+ "want to rotate the list:");
			int k = scan.nextInt();
			rotateList(k);
			break;

		case "E":
			System.out.println("Enter the k nodes you want to" + " reverse");
			int reverseK = scan.nextInt();
			reverseGroup(reverseK);
			break;
			
		case "F":
			System.out.println("Enter the first position");
			int m = scan.nextInt();
			System.out.println("Enter second position");
			int n = scan.nextInt();
			reversePosition(m, n);
			break;

		default:
			// scan.close();
			break;
		}
	}
}
