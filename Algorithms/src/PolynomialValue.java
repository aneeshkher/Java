public class PolynomialValue {
	public long temp;

	public long getValue(int terms, int value, int degree[], int coeff[]) {
		long answer = 0;
		temp = 1;
		for (int i = 0; i < terms; i++) {
			for (int j = 0; j < degree[i]; j++) {
				// System.out.println("Degree is " + degree[i]);
				if (degree[i] == 0) {
					System.out.println("Breaking from the loop!");
					break;
				}
				temp = temp * value;
			}
			temp = coeff[i] * temp;
			answer = answer + temp;
			temp = 1;
		}

		return answer;
	}

	public long hornerRule(int degree[], int coeff[], int value) {

		// System.out.println("Value received is: " + value);
		long answer = 0;
		int n = coeff.length;

		for (int i = n - 1; i >= 0; i--) {
			answer = answer * value + coeff[i];
		}
		return answer;
	}

	public void checkZero(int[] a) {
		if (a[3] == 0) {
			System.out.println("a is zero");
		} else {
			System.out.println("a is NOT zero!");
		}
	}
}
