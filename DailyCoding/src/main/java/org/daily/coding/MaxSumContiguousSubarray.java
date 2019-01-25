package org.daily.coding;

import java.util.ArrayList;
import java.util.List;

public class MaxSumContiguousSubarray {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
//		A.add(-163);
//		A.add(-20);
//		A.add(15);
		A.add(11);
		A.add(-3);
		A.add(4);
		A.add(-1);
		A.add(2);
		A.add(1);
		A.add(-5);
		A.add(4);
		int maxSum = new MaxSumContiguousSubarray().maxSubArray(A);
		System.out.println(maxSum);

	}

	public int maxSubArray(final List<Integer> A) {
		int finalMaxSum = A.get(0);
		int tempMaxSum = A.get(0);
		for (int i = 1; i < A.size(); i++) {
			int current = A.get(i);
			tempMaxSum = tempMaxSum + current;
			if (tempMaxSum < current) {
				tempMaxSum = current;
			}

			if (finalMaxSum < tempMaxSum) {
				finalMaxSum = tempMaxSum;
			}
		}
		return finalMaxSum;
	}
}
