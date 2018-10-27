package backtracking;

import java.util.Arrays;

public class PrintAllBinaryStrings {
	int[] binaryArr;

	public PrintAllBinaryStrings(int n) {
		binaryArr = new int[n];
		System.out.println("OUTPUT: binary String of n = 3 bits:");
	}

	public void binaryString(int index, int lenght) {
		if (index > lenght) {
			System.out.println(Arrays.toString(binaryArr));
		} else {
			binaryArr[index] = 0;
			binaryString(index + 1, lenght);
			binaryArr[index] = 1;
			binaryString(index + 1, lenght);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		int n = 3;
		PrintAllBinaryStrings i = new PrintAllBinaryStrings(n);
		i.binaryString(0, n - 1);
	}
}


