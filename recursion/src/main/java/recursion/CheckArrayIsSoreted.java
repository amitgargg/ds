package recursion;

public class CheckArrayIsSoreted {

	private static boolean isArraySorted(int[] intArray, int length) {
		if (length == 1) {
			return true;
		}
		return (intArray[length - 1] < intArray[length - 2]) ? 
					false : isArraySorted(intArray, length - 1);
	}
		
	public static void main(String[] args) {
		int[] intArray = {1, 2};
		System.out.println(isArraySorted(intArray, intArray.length));
	}
}
