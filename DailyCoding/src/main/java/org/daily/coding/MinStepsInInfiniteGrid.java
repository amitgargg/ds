package org.daily.coding;

import java.util.ArrayList;

/* PROBLEM
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * 	(x,y) to 
 *  (x+1, y), 
 *  (x - 1, y), 
 *  (x, y+1), 
 *  (x, y-1), 
 *  (x-1, y-1), 
 *  (x+1,y+1), 
 *  (x-1,y+1), 
 *  (x+1,y-1) 
 * You are given a sequence of points and the order in which you need to cover the points. 
 * Give the minimum number of steps in which you can achieve it. You start from the first point.
 * 
 * Given:
 * Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.
 * 
 * Return an Integer, i.e minimum number of steps.
 * 
 * Example:
 * Input : [(0, 0), (1, 1), (1, 2)]
 * Output : 2
 * 
 * It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 */

public class MinStepsInInfiniteGrid {

	public int fastest(ArrayList<Integer> A, ArrayList<Integer> B) {

		int dist = 0;
		int i = 1;
		while (i < A.size()) {
			dist += Math.max(Math.abs(A.get(i) - A.get(i - 1)), Math.abs(B.get(i) - B.get(i - 1)));
			i++;
		}
		return dist;
	}

	public int best(ArrayList<Integer> X, ArrayList<Integer> Y) {
		int numSteps = 0;
		for (int i = 1; i < X.size(); i++) {
			numSteps += Math.max(Math.abs(X.get(i) - X.get(i - 1)), Math.abs(Y.get(i) - Y.get(i - 1)));
		}
		return numSteps;
	}

	public int mySolution(ArrayList<Integer> A, ArrayList<Integer> B) {

		int count = 0;

		validateSize(A, B);

		if (A.size() == 1) {
			return 0;
		}

		for (int i = 1; i < A.size(); i++) {
			int previousA = A.get(i - 1);
			int previousB = B.get(i - 1);

			int currentA = A.get(i);
			int currentB = B.get(i);

			while (currentA != previousA || currentB != previousB) {
				if (currentA > previousA && currentB > previousB) {
					previousA = previousA + 1;
					previousB = previousB + 1;
				} else if (currentA < previousA && currentB < previousB) {
					previousA = previousA - 1;
					previousB = previousB - 1;
				} else if (currentA > previousA && currentB < previousB) {
					previousA = previousA + 1;
					previousB = previousB - 1;
				} else if (currentA < previousA && currentB > previousB) {
					previousA = previousA - 1;
					previousB = previousB + 1;
				} else if (currentA < previousA && currentB == previousB) {
					previousA = previousA - 1;
				} else if (currentA > previousA && currentB == previousB) {
					previousA = previousA + 1;
				} else if (currentA == previousA && currentB < previousB) {
					previousB = previousB - 1;
				} else if (currentA == previousA && currentB > previousB) {
					previousB = previousB + 1;
				}
				count = count + 1;
			}

		}

		return count;
	}

	private void validateSize(ArrayList<Integer> A, ArrayList<Integer> B) {
		if (A.isEmpty() || B.isEmpty() || A.size() != B.size()) {
			throw new RuntimeException();
		}
	}

	public static void main(String... s) {

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);
		a.add(-1);

		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(0);
		b.add(5);

		int steps = new MinStepsInInfiniteGrid().mySolution(a, b);
		System.out.println(steps);
	}

}
