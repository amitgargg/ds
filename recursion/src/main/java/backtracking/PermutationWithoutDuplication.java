package backtracking;

public class PermutationWithoutDuplication {

	public static void main(String[] args) {
		char[] str = { 'A', 'A', 'B' };
		int length = str.length;
		findPermutations(str, 0, length-1);
	}

	private static void findPermutations(char charArray[], int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			System.out.println(new String(charArray));
		}

		for (int i = startIndex; i <= endIndex; i++) {
			boolean check = shouldSwap(charArray, startIndex, i);
			if (check) {
				charArray = swap(charArray, startIndex, i);
				findPermutations(charArray, startIndex + 1, endIndex);
				charArray = swap(charArray, startIndex, i);
			}
		}
	}

	private static boolean shouldSwap(char str[], int swapIndex, int swapWithIndex) {
		for (int i = swapIndex; i < swapWithIndex; i++)
			if (str[i] == str[swapWithIndex])
				return false;
		return true;
	}

	private static char[] swap(char[] charArray, int swapIndex, int swapWithIndex) {
		char swapCharacter = charArray[swapIndex];
		charArray[swapIndex] = charArray[swapWithIndex];
		charArray[swapWithIndex] = swapCharacter;
		return charArray;
	}
}
