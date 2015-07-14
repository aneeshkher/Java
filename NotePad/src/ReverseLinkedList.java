public class ReverseLinkedList {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static LNode reverseLinkedList(LNode list) {
		LNode temp = new LNode();
		LNode prev = new LNode();
		LNode newList = new LNode();
		temp = list;
		// INSERT YOUR CODE HERE
		int count = 0;
		while (temp.next != null) {
			temp = temp.next;
			count++;
		}
		temp = list;
		if ((count % 2) == 0) {
			count = count / 2;

		} else {
			count = (count++) / 2;
		}
		int i = 0;
		while (i < count) {
			temp = temp.next;
		}
		prev = null;
		newList.value = temp.value;
		while (temp != null) {
		    LNode tempNew = new LNode();
		    tempNew.value = temp.value;
			tempNew.next = prev;
			temp = temp.next;
			prev = tempNew;
			if (temp == null) {
			    return tempNew;
			}
		}
		
		return list;
	}

	// METHOD SIGNATURE ENDS

	// DO NOT IMPLEMENT main( ) METHOD
	public static void main(String[] args) {
		// PLEASE DO NOT MODIFY THIS FUNCTION
		// YOUR FUNCTION SHALL BE AUTOMATICALLY CALLED AND THE INPUTS FROM HERE
		// SHALL BE PASSED TO IT
		LNode l1 = new LNode();
		LNode l2 = new LNode();
		// ASSUME INPUTS HAVE ALREADY BEEN TAKEN
		l2 = reverseLinkedList(l1);
		System.out.println(l2);
		// Print the output
	}
}