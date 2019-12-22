package ACSL;

public class Number {

	public static void main(String[] args) {
		int b = 1;
		int out = 0;
		while (b <= 9) {
			out = out * 10 + b;
			b++;
			System.out.println(out);
		}
	}
}
