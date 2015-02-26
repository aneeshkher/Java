
public class TestFindPeak {

	public static void main(String[] args) {
		int[] numArray = new int[]{1,4,7,2,3,10,9,7,2,7,4,8,0,4,2,6,3,2};
		
		Peaks p1 = new Peaks();
		int peak = p1.FindPeak(numArray);
		System.out.println("Peak is: " + peak);
		
	}

}
