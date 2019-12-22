package ACSL;

import java.util.Scanner;

public class AddTwoNumbers {
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		// This program can add two integers without limit in amount of digits
		// INPUT
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your first value");
		String numOne = input.next();
		System.out.println("Enter your second value");
		String numTwo = input.next();
		// ONE
		while (numTwo.length() > numOne.length()) {
			numOne = "0" + numOne;
		}
		int lengthOne = numOne.length();
		char[] one = new char[lengthOne];
		int[] oneArray = new int[lengthOne];
		for (int i = 0; i < lengthOne; i++) {
			one[i] = numOne.charAt(i);
		}
		for (int i = 0; i < lengthOne; i++) {
			oneArray[i] = one[i] - 48;
		}
		// TWO
		while (numTwo.length() < numOne.length()) {
			numTwo = "0" + numTwo;
		}
		int lengthTwo = numTwo.length();
		char[] Two = new char[lengthTwo];
		int[] TwoArray = new int[lengthTwo];
		for (int i = 0; i < lengthTwo; i++) {
			Two[i] = numTwo.charAt(i);
		}
		for (int i = 0; i < lengthTwo; i++) {
			TwoArray[i] = Two[i] - 48;
		}
		// ADDING
		int[] added = new int[lengthOne];
		int x = 0;
		int b = 0;
		for (int i = added.length - 1; i >= 0; i--) {
			added[i] = oneArray[i] + TwoArray[i] + b;
			b = 0;
			if (added[i] > 9) {
				b = 0;
				if (i > 0) {
					added[i] %= 10;
					b = 1;
				}
			}
		}
		// OUTPUT
		System.out.println();
		System.out.println("This is the output");
		for (int i = 0; i < lengthTwo; i++) {
			System.out.print(added[i]);
		}
	}
}
