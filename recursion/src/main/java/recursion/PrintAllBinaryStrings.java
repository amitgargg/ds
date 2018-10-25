package recursion;

import java.util.Arrays;

public class PrintAllBinaryStrings {
	int[] arrA;

	public PrintAllBinaryStrings(int n) {
		arrA = new int[n];
	}

	public void nBits(int n) {
		if (n <= 0) {
			System.out.println(Arrays.toString(arrA));
		} else {
			arrA[n - 1] = 0;
			nBits(n - 1);
			arrA[n - 1] = 1;
			nBits(n - 1);
		}
	}
	

	public static void main(String[] args) throws java.lang.Exception {
		int n = 3;
		PrintAllBinaryStrings i = new PrintAllBinaryStrings(n);
		i.nBits(n);
	}
}
