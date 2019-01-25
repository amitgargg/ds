package org.daily.coding;

import java.util.ArrayList;

public class AddOneToNumber {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();

		A.add(2);
		A.add(5);
		A.add(6);
		A.add(8);
		A.add(6);
		A.add(1);
		A.add(2);
		A.add(4);
		A.add(5);
		A.add(2);
		
		
		ArrayList<Integer> result = new AddOneToNumber().plusOne(A);
		System.out.println(result);
	}

	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		ArrayList<Integer> result = new ArrayList<>(A);
		int reminder = 0;
		for (int i = A.size() - 1; i >= 0; i--) {
			int digit = A.get(i);
			reminder = plusOne(i, digit, result);
			if (reminder == 0) {
				break;
			}
		}
		if (reminder == 1) {
			result.add(0, 1);
		}
		removeFrontZero(result);

		return result;
	}

	private int plusOne(int index, int digit, ArrayList<Integer> result) {
		int reminder = 0;
		int addOne = digit + 1;
		if (addOne == 10) {
			result.set(index, 0);
			reminder = 1;
		} else {
			result.set(index, addOne);
		}
		return reminder;
	}

	private void removeFrontZero(ArrayList<Integer> result) {
		for (int i = 0; i < result.size(); i++) {
			if (result.get(0) == 0) {
				result.remove(0);
			}
		}

	}

}
