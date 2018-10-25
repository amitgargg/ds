package recursion;

public class CheckArraySorting {

	private static boolean arraySorted(int[] a, int length) {
		if (length == 1) {
			return true;
		}
		return (a[length - 1] < a[length - 2]) ? false : arraySorted(a, length - 1);
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 10, 19, 15 };
		int length = 8;
		System.out.println(arraySorted(a, length));
	}
}
