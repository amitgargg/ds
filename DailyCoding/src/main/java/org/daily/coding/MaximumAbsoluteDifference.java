package org.daily.coding;

import java.util.ArrayList;

public class MaximumAbsoluteDifference {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(3);
		A.add(-1);

		System.out.println(new MaximumAbsoluteDifference().maxArr(A));

	}

	public int maxArr(ArrayList<Integer> A) {
		int max1 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;
		int min2 = Integer.MAX_VALUE;

		for (int i = 0; i < A.size(); i++) {
			max1 = Math.max(max1, A.get(i) + i);
			min1 = Math.min(min1, A.get(i) + i);
			max2 = Math.max(max2, A.get(i) - i);
			min2 = Math.min(min2, A.get(i) - i);
		}

		return Math.max(max1 - min1, max2 - min2);
	}

//	public int maxArr(ArrayList<Integer> A) {
//		if (A.isEmpty()) {
//			throw new RuntimeException();
//		}
//		int maxSum = 0;
//		for (int i = 0; i < A.size(); i++) {
//			for (int j = i + 1; j < A.size(); j++) {
//				maxSum = Math.max(sum(A, i, j), maxSum);
//			}
//		}
//		return maxSum;
//	}

	private int sum(ArrayList<Integer> A, int i, int j) {
		return (A.get(i) + i) - (A.get(j) + j);
	}
}
