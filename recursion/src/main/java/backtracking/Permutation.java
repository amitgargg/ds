package backtracking;

public class Permutation {

	public static void main(String[] args) {
		String s = "ABC";
		permutation(s, 0, s.length()-1);
	}

	private static void permutation(String s, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			System.out.print(s+", ");
		} else {
			for (int j = startIndex; j <= endIndex; j++) {
				s = swap(s, startIndex, j);
				permutation(s, startIndex + 1, endIndex);
				s = swap(s, startIndex, j);  // BackTracking
			}
		}
	}

	private static String swap(String s, int swapIndex, int swapWithIndex) {
		char[] charArray = s.toCharArray();
		char swapCharacter = charArray[swapIndex];
		charArray[swapIndex] = charArray[swapWithIndex];
		charArray[swapWithIndex] = swapCharacter;
		s = String.valueOf(charArray);
		return s;
	}
}
