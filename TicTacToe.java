package ACSL;

import java.util.Scanner;

public class TicTacToe {

	public static void printBoard() {

		/*
		 * Scanner input = new Scanner(System.in);
		 * 
		 * char board[][] = new char[3][3]; int k, l, b, a = 0; int c = 0;
		 * 
		 * for (k = 0; k < 3; k++) { for (l = 0; l < 3; l++) { board[k][l] = '.'; } }
		 * 
		 * for (k = 0; k < 3; k++) { for (l = 0; l < 3; l++) {
		 * System.out.print(board[k][l] + " "); } System.out.println(); }
		 */

	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		char board[][] = new char[3][3];
		int k, l, x, a, b;

		for (k = 0; k < 3; k++) {
			for (l = 0; l < 3; l++) {
				board[k][l] = '.';
			}
		}

		for (k = 0; k < 3; k++) {
			for (l = 0; l < 3; l++) {
				System.out.print(board[k][l] + " ");
			}
			System.out.println();
		}

		for (x = 0; x < 9; x++) {
			a = 0;
			while (a == 0) {
				System.out.println("Player one give your input in the form of [column, row]");

				int i = input.nextInt() - 1;
				int j = input.nextInt() - 1;

				if (board[i][j] != 'x' && board[i][j] != 'o') {
					board[i][j] = 'x';
					a++;
				}

				else {
					System.out.println("Enter another input.");
				}
			}

			for (k = 0; k < 3; k++) {
				for (l = 0; l < 3; l++) {
					System.out.print(board[k][l] + " ");
				}
				System.out.println();
			}

			if ((board[0][0] == 'x' && board[0][1] == 'x' && board[0][2] == 'x')
					|| (board[1][0] == 'x' && board[1][1] == 'x' && board[1][2] == 'x')
					|| (board[2][0] == 'x' && board[2][1] == 'x' && board[2][2] == 'x')) {
				System.out.println("player 1 won");
				break;
			}

			if ((board[0][0] == 'x' && board[1][0] == 'x' && board[2][0] == 'x')
					|| (board[0][1] == 'x' && board[1][1] == 'x' && board[2][1] == 'x')
					|| (board[0][2] == 'x' && board[1][2] == 'x' && board[2][2] == 'x')) {
				System.out.println("player 1 won");
				break;

			}

			if ((board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x')
					|| (board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x')) {
				System.out.println("player 1 won");
				break;
			}

			b = 0;

			while (b == 0) {
				System.out.println("Player two give your input in the form of [column, row]");

				int m = input.nextInt() - 1;
				int n = input.nextInt() - 1;
				if (board[m][n] != 'x' && board[m][n] != 'o') {
					board[m][n] = 'o';
					b++;
				} else {
					System.out.println("Enter another input.");
				}
			}

			for (k = 0; k < 3; k++) {
				for (l = 0; l < 3; l++) {
					System.out.print(board[k][l] + " ");
				}
				System.out.println();
			}

			if ((board[0][0] == 'o' && board[0][1] == 'o' && board[0][2] == 'o')
					|| (board[1][0] == 'o' && board[1][1] == 'o' && board[1][2] == 'o')
					|| (board[2][0] == 'o' && board[2][1] == 'o' && board[2][2] == 'o')) {
				System.out.println("player 2 won");
				break;
			}
			if ((board[0][0] == 'o' && board[1][0] == 'o' && board[2][0] == 'o')
					|| (board[0][1] == 'o' && board[1][1] == 'o' && board[2][1] == 'o')
					|| (board[0][2] == 'o' && board[1][2] == 'o' && board[2][2] == 'o')) {
				System.out.println("player 2 won");
				break;

			}

			if ((board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o')
					|| (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o')) {
				System.out.println("player 2 won");
				break;
			}
		}
	}
}
