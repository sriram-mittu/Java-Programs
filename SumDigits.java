package ACSL;

public class SumDigits {

	public static void main(String[] args) {
		int num = 4353;

		System.out.println("The number is : " + num);

		int sum = 0;
		while (num > 0) {
			sum = sum + num % 10;
			num = num / 10;
		}
		System.out.println("The sum of digits in number is : " + sum);
	}

}
