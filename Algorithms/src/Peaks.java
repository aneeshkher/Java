import java.util.ArrayList;


public class Peaks {
	
	int peak;
	int arrLen;
	int i;
	
	public int FindPeak(int[] a) {
		ArrayList<Integer> peaks = new ArrayList<Integer>();
		arrLen = a.length;
		peak = 1;
		for (i=0; i<arrLen; i++) {
			System.out.print(a[i] + " ");
			if (i == 0) {
				if (a[i] > a[i+1]) {
					peaks.add(a[i]);
				} 
			} else if (i == arrLen - 1) {
				if (a[i] > a[i-1]) {
					peaks.add(a[i]);
				}
			} else {
				if ((a[i] > a[i-1]) && (a[i] > a[i+1])) {
					peaks.add(a[i]);
				}
			}
		}
		System.out.println("");
		System.out.println("Peaks in the array are: " + peaks);
		return peak;
	}
}
