package org.searching;

public class LinearSearch {

	public static void main(String[] args) {
		int data[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int index = search(data, 50);
		System.out.println(index);

	}

	public static int search(int[] data, int search) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == search) {
				return i;
			}
		}
		return -1;
	}

}
