package org.searching;

public class BinarySearch {
	
	public static void main(String[] args) {
		int data[] = {-10 , 10, 20, 30};
		int index = search(0, data.length-1, data, 30);
		System.out.println(index);
	}

	public static int search(int low, int high, int[] data, int search) {
		if (high < low) {
			return -1;
		}
		int middle = middle(low, high);
		if (data[middle] == search) {
			return middle;
		} else if (data[middle] > search) {
			high = middle - 1;
			return search(low, high, data, search);
		} else {
			low = middle + 1;
			return search(low, high, data, search);
		}

	}

	private static int middle(int low, int high) {
		return (low + high) / 2;
	}
}
