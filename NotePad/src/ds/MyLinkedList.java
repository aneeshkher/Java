package ds;

import java.util.Scanner;

public class MyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int flag = 0;

		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

		for (int i : a) {
			insert(i, scan);
		}
		while (true) {
			System.out.println("Enter your choice:");
			System.out.println("A. Insert");
			System.out.println("B. Delete");
			System.out.println("C. Print");
			System.out.println("D. Search");
			System.out.println("E. Reverse");
			System.out.println("F. Exit");
			System.out.println("G. Other options");

			String option = scan.next();
			switch (option.toUpperCase()) {
			case "A":
				System.out.println("Enter whether you want to:");
				System.out.println("a. Append to end of list");
				System.out.println("b. Insert after a specific element");
				System.out.println("c. Insert at the beginning");

				String insertOption = scan.next();
				switch (insertOption.toUpperCase()) {
				case "A":
					System.out.println("Inside case A of insert");
					System.out.println("Enter the data to be added to the "
							+ "end of the list");
					int data = scan.nextInt();
					insert(data, scan);
					break;
				case "B":
					System.out.println("Inside case B of insert");
					System.out.println("Enter the data to be inserted");
					int dataMid = scan.nextInt();
					printList();
					System.out
							.println("Enter the element after which you want "
									+ "to insert");
					int nextData = scan.nextInt();
					insertAfter(nextData, dataMid, scan);
					break;
				case "C":
					System.out.println("Inside case C of insert");
					int dataBeg = scan.nextInt();
					insertBeginning(dataBeg);
					break;
				default:
					System.out.println("Invalid option");
				}
				break;

			case "B":
				System.out.println("Choose option.");
				System.out.println("A. Delete root");
				System.out.println("B. Delete specific element");
				String delOption = scan.next();
				switch (delOption.toUpperCase()) {
				case "A":
					deleteRoot();
					break;
				case "B":
					System.out.println("Enter the specific element"
							+ " to be deleted:");
					int delData = scan.nextInt();
					deleteOther(delData);
					break;
				default:
					System.out.println("Improper option selected.");
				}
				break;
			case "C":
				System.out.println("");
				printList();
				break;
			case "D":
				System.out.println("Enter the element to be searched");
				int dataSearch = scan.nextInt();
				if (searchList(dataSearch)) {
					System.out.println("Data found in the list");
				} else {
					System.out.println("Data NOT found in the list");
				}
				break;
			case "E":
				reverse();
				break;
			case "F":
				flag = 1;
				break;
			case "G":
				ListOptions l1 = new ListOptions();
				l1.chooseOption(scan);
				break;
			default:
				break;
			}
			if (flag == 1) {
				scan.close();
				break;
			}

		}

	}

	public static void reverse() {
		Node previous = null;
		Node next = Root.root.next;
		Node current = Root.root;

		while (current.next != null) {
			current.next = previous;
			previous = current;
			current = next;
			next = current.next;
		}

		Root.root = current;
		Root.root.next = previous;
	}

	public static void deleteRoot() {
		Root.root = Root.root.next;
	}

	public static boolean deleteOther(int data) {
		if (Root.root.data == data) {
			deleteRoot();
			return true;
		} else {
			Node temp = Root.root;
			while (temp.next.data != data) {
				temp = temp.next;
				if (temp == null) {
					return false;
				}
			}
			temp.next = temp.next.next;
			return true;
		}
	}

	public static void insertAfter(int dataAfter, int data, Scanner scan) {
		if (searchList(dataAfter)) {
			Node temp = Root.root;
			while (temp.data != dataAfter) {
				temp = temp.next;
			}
			Node newNode = new Node();
			newNode.data = data;
			newNode.next = temp.next;
			temp.next = newNode;
		} else {
			System.out.println("Data not found in the list.");
		}
	}

	public static void insertBeginning(int data) {
		if (Root.root == null) {
			Root.root = new Node();
			Root.root.data = data;
			Root.root.next = null;
		} else {
			Node newNode = new Node();
			newNode.next = null;
			newNode.data = data;
			newNode.next = Root.root;
			Root.root = newNode;
		}
	}

	public static void insert(int data, Scanner scan) {

		if (Root.root == null) {
			Root.root = new Node();
			Root.root.data = data;
			Root.root.next = null;
		} else {
			Node traverse = Root.root;
			while (traverse.next != null) {
				traverse = traverse.next;
			}
			Node addNode = new Node();
			addNode.data = data;
			addNode.next = traverse.next;
			traverse.next = addNode;

		}
	}

	public static boolean searchList(int data) {
		Node temp = Root.root;
		while (temp != null) {
			if (temp.data == data) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public static void printList() {

		Node temp = Root.root;
		System.out.println("");
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("NULL");
		System.out.println("");
	}

}
