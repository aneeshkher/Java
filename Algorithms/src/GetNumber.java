public class GetNumber {
	public int getSmallest(int A[]) {
		int small;
		small = A[0];
		for (int a : A) {
			if (a < small) {
				small = a;
			}
		}
		return small;
	}
}
