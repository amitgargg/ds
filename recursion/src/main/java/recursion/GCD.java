package recursion;

public class GCD {

	public static void main(String[] args) {
		System.out.println(gcd(99, 10));

	}

	private static int gcd(int a, int b) {
		if (a == 0 || b == 0) {
			return 0;
		}
		if (a == b) {
			return a;
		}
		if (a % b == 0) {
			return b;
		}
		if (b % a == 0) {
			return a;
		}
		if (a > b) {
			return gcd(a % b, b);
		} else {
			return gcd(a, b % a);
		}
	}
}
