package org.DailyCoding;

/*
Fizz Buzz is a group word game for children to teach them about division.
Players take turns to count incrementally, replacing any number divisible by three with the word “fizz”, 
and any number divisible by five with the word “buzz” and any number divisible by both three and five is
replaced with the word “fizzbuzz”

For example, a typical round of fizz buzz would start as follows:
1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz, 16, 17, Fizz, 19, Buzz, 
Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, Fizz Buzz, 31, 32, Fizz, 34, Buzz, Fizz, …

Question — Write a program that prints the numbers from 1 to n and for multiples of ‘3’ print “Fizz” 
instead of the number, for the multiples of ‘5’ print “Buzz”, and for the numbers which are divisible 
by both 3 and 5, print FizzBuzz.
*/

public class DayOneFizzBuzz {

	public static void main(String[] args) {
		printFizzBuzz(29, 33);
	}

	private static void printFizzBuzz(int startIndex, int endIndex) {

		for (int i = startIndex; i <= endIndex; i++) {
			String result = "";
			if (isDivisibleByThree(i)) {
				result = result + "Fizz";
			}

			if (isDivisibleByFive(i)) {
				result = result + " Buzz";
			}

			if (result == "") {
				result = String.valueOf(i);
			}
			System.out.print(result + ", ");
		}

	}

	private static boolean isDivisibleByThree(int number) {
		return isDivisible(number, 3);

	}

	private static boolean isDivisibleByFive(int number) {
		return isDivisible(number, 5);

	}

	private static boolean isDivisible(int number, int divider) {
		int result = number % divider;
		if (result == 0) {
			return true;
		}
		return false;
	}

}
