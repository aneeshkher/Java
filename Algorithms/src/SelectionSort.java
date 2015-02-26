public class SelectionSort {

	public static void main(String[] args) {
		int A[] = new int[20];
		for (int b = 0; b < A.length; b++) {
			A[b] = (int) (Math.random() * 100.0);
			// System.out.println( A[b]);

		}
		for (int temp : A) {
			System.out.print(temp + " ");
		}
		GetNumber g1 = new GetNumber();
		int smallest = g1.getSmallest(A);
		System.out.println("");
		System.out.println("Smallest number is: " + smallest);

	}

}
