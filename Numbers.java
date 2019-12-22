package ACSL;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Numbers {
	public static void main(String[] args) {
		System.out.println(one());
	}

	public static int one() {
		int a = 12;
		int b = 6;

		int c = a * b;
		int d = c % 3;

		int e = 0;
		if (d == 0) {
			e = c / 3;
		}
		return e;
	}

	public static double two() {
		double a = 17;
		double b = 9;

		double c = a % b;
		double d = c / a;
		return d;
	}

	private static char three(String[] args) {
		String str = "Hello";
		char b = str.charAt(0);
		return b;
	}

	private static int four() {
		int[] numbers = { 4, 5, 6 };
		System.out.println(Arrays.toString(numbers));
		return 0;
	}

	private static int five() {
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;

		int e = a + b + c + d;

		if (e < 20) {
			int f = e + 70;
			System.out.println(f);
		}
		return 0;
	}

	private static int six() {
		int a = 4;
		int b = 5;

		int c = a - b;
		int d;

		if (c < 0) {
			d = c * -5;
			System.out.println(d);
		}
		return 0;
	}

	private static int seven() {
		double a = 10;
		double b = 5;

		double c = a + b;
		double d = c / 2;
		System.out.println(d);
		return 0;
	}

	private static int eight() {
		double a = 12;
		double b = 9;

		double c = a % b;
		double d = a / b;

		if (c > 0) {
			double e = d * 100;
			System.out.println(e);
		}
		return 0;
	}

	public static int nine() {
		int a = 11;
		int b = 5;

		int c = a + b;
		int d = a % b;
		int e = c * d;
		System.out.println(e);
		return 0;
	}

	public static int ten() {
		int a = 10;
		int b = 5;
		int c = 2;

		int d = a + b;
		int e = d * c;

		System.out.println(e);
		return 0;
	}

	public static int eleven() {
		int a = 2;
		int b = 1;
		int c = 1;

		for (b = 1; b <= a; b++) {
			c = c * b;
		}
		System.out.println(c);
		return 0;
	}

	public static int twelve() {
		int a = 3;
		int b = 3;
		int c = 6;
		int d = 3;
		int e = 3;
		int f = 3;
		int g = 3;
		int h = 3;
		int i = a + b;
		int j = c - d;
		int k = e * f;
		int l = g / h;
		int m = i * j * k * l;
		System.out.println(m);
		return 0;
	}

	public static void thirteen(String[] args) {
		String input = "olleH";
		String output = "";

		for (int a = input.length() - 1; a >= 0; a--) {
			output = output + input.charAt(a);
		}
		System.out.println(output);
	}

	public static int fourteen() {
		int a = 16;
		int array[][] = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				array[i][j] = a;
				a++;
			}
		}

		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				System.out.print(array[k][l]);
				System.out.print(" ");
			}
			System.out.println("");
		}
		return 0;
	}

	public static void fifteen(String[] args) {
		int a = 1;
		String str = "99";
		int b = Integer.parseInt(str);
		int c = a + b;
		String d = "" + a + b;

		System.out.println(c);
		System.out.println(d); // Question : Whether to print as a number or as a string?
	}
}
