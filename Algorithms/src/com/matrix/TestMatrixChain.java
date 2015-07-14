package com.matrix;

import java.util.ArrayList;

public class TestMatrixChain {

	// public ArrayList<Integer> d = new ArrayList<Integer>();

	//static int[] d = new int[] { 10, 15, 20, 25, 30, 35, 24, 47, 59 };
	//static int[] d = new int[] { 1,5,3,9,1,2,7,3,4,6,5,2,1,2 };
	//static int[] d = new int[] { 6, 1, 3, 5, 7, 8, 4, 9, 20, 4, 9, 1, 5, 2 };
	
	static int[] d = new int[] {5,6,4,8,7,9,7,8,6,9,3,7,6,5};
	static int inputLength = d.length;
	
	/*
	 * Set the size of the arrays to a square matrix
	 * with dimensions one more than the number of dimensions.
	 */
	//static int[][] m = new int[inputLength + 1][inputLength + 1];
	static int[][] recurseM = new int[inputLength + 1][inputLength + 1];
	static int[][] memM = new int[inputLength + 1][inputLength + 1];
	
	static int[][] recurseS = new int[inputLength + 1][inputLength + 1];
	static int[][] memS = new int[inputLength + 1][inputLength + 1];
	
	static ArrayList<Integer> kValues = new ArrayList<Integer>();
	static int multCount;
	static int count;
	static int countM;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] a = new double[] { 2, 2000, 2, 2000 };

		double first = (a[1] * a[2] * a[3] + a[0] * a[1] * a[3]);
		double second = (a[0] * a[1] * a[2] + a[0] * a[2] * a[3]);

		double answer = first / second;
		System.out.println("First: " + first + ". Second: " + second);
		System.out.println("Multiplications ratio: " + answer);

		/*
		 * Initializing the matrices and other values
		 */
		
		count = 0;
		countM = 0;
		multCount = 0;

		for (int i = 0; i < inputLength + 1; i++) {
			for (int j = 0; j < inputLength + 1; j++) {
				memM[i][j] = -1;
			}
		}

		for (int i = 0; i < inputLength + 1; i++) {
			memM[i][i] = 0;
		}

		for (int i = 0; i < inputLength + 1; i++) {
			for (int j = 0; j < inputLength + 1; j++) {
				recurseM[i][j] = -1;
			}
		}

		for (int i = 0; i < inputLength + 1; i++) {
			recurseM[i][i] = 0;
		}

		/*
		 * Recursive method.
		 */
		System.out.println("-----Recursive method-----");
		
		/*
		 * Calculating total time
		 */
		long recStart = System.nanoTime();
		int minCost = multiply(1, inputLength - 1);
		long recEnd = System.nanoTime();
		long recTotalTime = recEnd - recStart;
		
		
		/*
		 * Printing the M and S matrices which hold the values
		 */
		System.out.println("M Matrix");
		for (int i = 1; i < inputLength; i++) {
			for (int j = 1; j < inputLength; j++) {
				System.out.print(recurseM[i][j] + "	");
			}
			System.out.println("");
		}
		
		System.out.println("S Matrix");
		for (int i = 1; i < inputLength; i++) {
			for (int j = 1; j < inputLength; j++) {
				System.out.print(recurseS[i][j] + "   ");
			}
			System.out.println("");
		}
		
		System.out.println("Total time: " + recTotalTime);
		System.out.println("Recursive calls: " + count);
		System.out.println("Scalar multiplications: " + multCount);
		System.out.println("Minimum cost: " + minCost);
		multCount = 0;
		System.out.println("-------------------------");
		
		/*
		 * Dynamic programming method. Non-recursive
		 */
		System.out.println("-----Dynamic programming method-----");

		multDynamic(inputLength - 1);
	
		System.out.println("-------------------------");
		
		
		/*
		 * Memoized version
		 */
		System.out.println("-----Memoizing method-----");
		multCount = 0;
		
		/*
		 * Calculating the time taken
		 */
		long memStart = System.nanoTime();
		int memMinCost = memoizeDynamic(1, inputLength - 1);
		long memEnd = System.nanoTime();
		long memTotal = memEnd - memStart;

		/*
		 * Printing the M and S matrices which hold the values
		 */
		System.out.println("After");
		for (int i = 1; i < inputLength; i++) {
			for (int j = 1; j < inputLength; j++) {
				System.out.print(memM[i][j] + "\t");
			}
			System.out.println("");
		}
		
		System.out.println("S Matrix");
		for (int i = 1; i < inputLength; i++) {
			for (int j = 1; j < inputLength; j++) {
				System.out.print(memS[i][j] + "	");
			}
			System.out.println("");
		}
		
		System.out.println("Total time: " + memTotal);
		System.out.println("Recursive calls: " + countM);
		System.out.println("Scalar multiplications: " + multCount);
		System.out.println("Minimum cost: " + memMinCost);
		System.out.println("-------------------------");
		System.out.println();
	}

	/*
	 * Recursive method to find the total
	 * number of scalar multiplications
	 */
	public static int multiply(int i, int j) {
		count++;
		if (i == j) {
			return 0;
		} else {
			int k, cost, minK;
			int minCost = -1;
			minK = -1;
			for (k = i; k < j; k++) {
				cost = multiply(i, k) + multiply(k + 1, j) + d[i - 1] * d[k]
						* d[j];
				multCount += 2;
				if (minCost == -1) {
					minCost = cost;
					minK = k;
				} else {
					if (cost < minCost) {
						minCost = cost;
						minK = k;
					}
				}
			}
			recurseM[i][j] = minCost;
			recurseS[i][j] = minK;
			kValues.add(minK);
			return minCost;
		}
	}

	
	/*
	 * Dynamic programming method to find the
	 * total number of multiplications.
	 */
	public static void multDynamic(int n) {
		int m[][] = new int[n + 1][n + 1];
		int s[][] = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			m[i][i] = 0;
		}
		int minCost;
		int  multCount = 0;
		int cost, minK;
		minK = -1;
		int recCallCount = 0;
		long dynStart = System.nanoTime();
		for (int i = n - 1; i > 0; i--) {
			for (int j = i + 1; j <= n; j++) {
				minCost = -1;
				for (int k = i; k < j; k++) {
					/*
					 * System.out .println("i = " + i + ". j = " + j + ". k = "
					 * + k); System.out.println(d[i - 1] + " " + d[k] + " " +
					 * d[j]);
					 */
					cost = m[i][k] + m[k + 1][j] + d[i - 1] * d[k] * d[j];
					recCallCount++;
					multCount += 2;
					if (minCost == -1) {
						minCost = cost;
						minK = k;
					} else {
						if (cost < minCost) {
							minCost = cost;
							minK = k;
						}
					}
				}
				m[i][j] = minCost;
				s[i][j] = minK;
			}
		}

		long dynEnd = System.nanoTime();
		long dynTotal = dynEnd - dynStart;
		
		System.out.println("M Matrix");
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				System.out.print(m[i][j] + "	");
			}
			System.out.println("");
		}

		System.out.println("");
		System.out.println("S Matrix");
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				System.out.print(s[i][j] + "	");
			}
			System.out.println("");
		}
		
		System.out.println("Scalar multiplications: " + multCount);
		System.out.println("Total time: " + dynTotal);
		System.out.println("Recursive calls: " + recCallCount);
		System.out.println("Minimum cost: " + m[1][n]);	
	}

	public static int memoizeDynamic(int i, int j) {
		countM++;
		if (i == j) {
			return 0;
		} else {
			int k, cost, minK;
			int minCost = -1;
			minK = -1;
			for (k = i; k < j; k++) {
				if (memM[i][k] == -1) {
					memM[i][k] = memoizeDynamic(i, k);
				}
				if (memM[k + 1][j] == -1) {
					memM[k + 1][j] = memoizeDynamic(k + 1, j);
				}
				cost = memM[i][k] + memM[k + 1][j] + d[i - 1] * d[k] * d[j];
				multCount += 2;
				//cost = memoizeDynamic(i, k) + memoizeDynamic(k + 1, j) + d[i - 1] * d[k] * d[j];
				if (minCost == -1) {
					minCost = cost;
					minK = k;
				} else {
					if (cost < minCost) {
						minCost = cost;
						minK = k;
					}
				}
			}
			memM[i][j] = minCost;
			memS[i][j] = minK;
			kValues.add(minK);
			return minCost;
		}
	}
}
