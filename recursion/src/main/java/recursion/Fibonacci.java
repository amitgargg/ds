package recursion;

public class Fibonacci {

	public static void main(String[] args) {
		fibonacciSeries(7);
	}

	public static void fibonacciSeries(int n) {
		int fibonacci[] = new int[2];
		fibonacci[0] = 0;
		fibonacci[1] = 1;

		for (int i = 0; i <= n; i++) {
			if (i < 2) {
				System.out.print(fibonacci[i]);
			} else {
				int sum = fibonacci[0] + fibonacci[1];
				fibonacci[0] = fibonacci[1];
				fibonacci[1] = sum;
				System.out.print(sum);
			}
			System.out.print(" ");
		}
	}
}
