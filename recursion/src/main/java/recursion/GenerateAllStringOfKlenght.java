package recursion;

import java.util.Arrays;

public class GenerateAllStringOfKlenght {
	static int []A;
	public static void kString(int n, int k) {
		if(n<1) {
			System.out.println(Arrays.toString(A));
		} else {
			for(int j=0;j<k;j++) {
				A[n-1] = j;
				kString(n-1, k);
			}
		}
	}
	
	
	public static void main(String[] args) {
		A = new int[1];
		kString(1, 10);
		
	}
}
