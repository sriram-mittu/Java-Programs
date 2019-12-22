package ACSL;

import java.util.Scanner;

public class Factorial {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// VARIABLE DECLARATION

		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number");
		String intake = input.next();

		char[] charArray = new char[intake.length()];
		String[] stringArray = new String[intake.length()];
		long[] longArray = new long[intake.length()];
		long[] extraArray = new long[intake.length()];

		double length = Math.ceil(intake.length() / 19);
		String output = "";

		// STRING TO LONG ARRAY CONVERSION

		for (int i = 0; i < intake.length(); i++) {
			charArray[i] = intake.charAt(i);
		}
		for (int i = 0; i < intake.length(); i++) {
			if (length <= 1) {
				if (i < 1) {
					stringArray[0] = "";
				}
				stringArray[0] += String.valueOf(charArray[i] - 48);
			} else if (length > 1) {
				for (int o = 0; o < 19; o++) {
					stringArray[i] += String.valueOf(charArray[o + (i * 19)] - 48);
				}
			}
		}

		// FINDING THE FACTORIAL

		for (int i = 0; i <= length; i++) {
			longArray[i] = Long.parseLong(stringArray[i]);
		}
		for (int i = 0; i <= length; i++) {
			extraArray[i] = longArray[i];
			// It will repeat if "i < the factorialed value" instead of "i < first value"
		}
		int a = 0;
		for (int x = 0; x <= length; x++) {
			for (int i = 1; i < extraArray[x]; i++) {
				longArray[x + a] *= i;
				Long yt = (long) String.valueOf(longArray[x]).length();
				if (yt > 18) {
					a++;
					increaseSize(longArray);
				}
			}
		}
		// OUTPUT

		for (int i = 0; i <= length; i++) {
			output += "" + longArray[i];
		}

		System.out.println("The factorial is of your number is");
		System.out.println(output);
	}

	public static void increaseSize(long[] original) {
		long[] temp = new long[original.length + 1];

		for (int i = 0; i < original.length; i++) {
			temp[i] = original[i];
		}
		original = temp;
	}
}