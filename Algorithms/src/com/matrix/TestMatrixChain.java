package com.matrix;

import java.util.ArrayList;

public class TestMatrixChain {

	// public ArrayList<Integer> d = new ArrayList<Integer>();

	public static int[] d = new int[] { 10, 15, 20, 25, 30, 35 };
	public static int[][] m = new int[7][7];
	public static int[][] memM = new int[7][7];
	public static int[][] recurseM = new int[7][7];
	public static ArrayList<Integer> kValues = new ArrayList<Integer>();

	static int count;
	static int countM;
	public TestMatrixChain() {
		count = 0;
		countM = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] a = new double[] { 2, 2000, 2, 2000 };

		double first = (a[1] * a[2] * a[3] + a[0] * a[1] * a[3]);
		double second = (a[0] * a[1] * a[2] + a[0] * a[2] * a[3]);

		double answer = first / second;
		System.out.println("First: " + first + ". Second: " + second);
		System.out.println("Multiplications ratio: " + answer);

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				m[i][j] = -1;
			}
		}

		for (int i = 0; i < 7; i++) {
			m[i][i] = 0;
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				memM[i][j] = -1;
			}
		}

		for (int i = 0; i < 7; i++) {
			memM[i][i] = 0;
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				recurseM[i][j] = -1;
			}
		}

		for (int i = 0; i < 7; i++) {
			recurseM[i][i] = 0;
		}

		System.out.println("-----Recursive method-----");
		int minCost = multiply(1, 5);
		System.out.println("Minimum cost: " + minCost);
		System.out.print("Values of k: ");
		for (int i : kValues) {
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("Recursive calls: " + count);

		System.out.println("M Matrix");
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				System.out.print(recurseM[i][j] + "	");
			}
			System.out.println("");
		}

		System.out.println("-------------------------");

		System.out.println("-----Dynamic programming method-----");
		multDynamic(5);
		System.out.println("-------------------------");
		System.out.println("-----Memoizing method-----");

		System.out.println("Before");
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				System.out.print(memM[i][j] + "	");
			}
			System.out.println("");
		}
		int memMinCost = memoizeDynamic(1, 5);

		System.out.println("After");
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				System.out.print(memM[i][j] + "	");
			}
			System.out.println("");
		}
		System.out.println("Recursive calls: " + countM);
		System.out.println("Minimum cost: " + memMinCost);
		System.out.println("-------------------------");
		System.out.println();
	}

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
			kValues.add(minK);
			return minCost;
		}
	}

	public static void multDynamic(int n) {
		int m[][] = new int[n + 1][n + 1];
		int s[][] = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			m[i][i] = 0;
		}
		int minCost;
		int cost, minK;
		minK = -1;
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
			kValues.add(minK);
			return minCost;
		}
	}
}
