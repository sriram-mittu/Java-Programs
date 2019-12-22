package ACSL;

public class Star {
	public static void main(String[] args) {
		String star = "*";
		String space = " ";
		int i, b, a, k = 0;
		a = 5;
		for (i = 1; i <= a; i++) {
			for (b = 1; b <= (a - i); b++) {
				System.out.print(space);
			}
			while (k != (2 * i - 1)) {
				System.out.print(star);
				k++;
			}
			k = 0;
			System.out.println("");
		}
	}
}
