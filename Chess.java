package ACSL;

import java.util.Scanner;

public class Chess {
	static Scanner input = new Scanner(System.in);
	static int i = 0;

	public static void main(String[] args) {
		String[][] chessboard = new String[8][8];
		chessboard = newboard(chessboard);
		int movecount = 0;
		boolean checkMate = false;
		printboard(chessboard);
		System.out.println("");

		while (!checkMate) {
			checkMate = whiteMove(chessboard, movecount);
			printboard(chessboard);
			if (checkMate) {
				System.out.println("White Wins!");
				break;
			}
			checkMate = blackMove(chessboard, movecount);
			printboard(chessboard);
			if (checkMate) {
				System.out.println("Black Wins!");
				break;
			}
		}
	}

	private static boolean whiteMove(String[][] chessboard, int movecount) {
		String movecolor = "w";
		// int a = -1;
		// int b = 1;
		System.out.println("White Move");
		int piecelocation = input.nextInt();
		int newplacey = piecelocation % 10;
		piecelocation /= 10;
		int newplacex = piecelocation % 10;
		piecelocation /= 10;
		int placey = piecelocation % 10;
		piecelocation /= 10;
		int placex = piecelocation % 10;

		if (validateMove(chessboard, placex, placey, newplacex, newplacey, movecolor, movecount)) {
			movePiece(chessboard, placex, placey, newplacex, newplacey);
		}
		// checkForCheck(chessboard);
		// checkForPieceKill(placex, placey, newplacex, newplacey, chessboard,
		// movecolor);
		// checkForCheckmate(chessboard);
		movecount++;
		return false;
	}

	private static boolean blackMove(String[][] chessboard, int movecount) {
		String movecolor = "b";
		// int a = 1;
		// int b = 1;
		System.out.println("Black Move");
		int piecelocation = input.nextInt();
		int newplacey = piecelocation % 10;
		piecelocation /= 10;
		int newplacex = piecelocation % 10;
		piecelocation /= 10;
		int placey = piecelocation % 10;
		piecelocation /= 10;
		int placex = piecelocation % 10;
		if (validateMove(chessboard, placex, placey, newplacex, newplacey, movecolor, movecount)) {
			movePiece(chessboard, placex, placey, newplacex, newplacey);
		}
		movecount++;
		return false;
	}

	@SuppressWarnings("unused")
	private static void checkForCheckmate(String[][] chessboard) {

	}

	@SuppressWarnings("unused")
	private static void checkForCheck(String[][] chessboard) {
		String[][] kingPlace;

	}

	private static void movePiece(String[][] chessboard, int placex, int placey, int newplacex, int newplacey) {
		if (chessboard[placex][placey] == "o ") {
			System.out.println("Thereas no piece there");
			System.out.println(chessboard[placex][placey]);
		}
		chessboard[newplacex][newplacey] = chessboard[placex][placey];
		chessboard[placex][placey] = "o ";
	}

	private static boolean validateMove(String[][] chessboard, int placex, int placey, int newplacex, int newplacey,
			String movecolor, int movecount) {
		if (!inBounds(newplacex, newplacey, chessboard)) {
			System.out.println("Your movement is not in bounds");
			return false;
		}
		if (sameColorPiece(placex, placey, newplacex, newplacey, chessboard, movecolor)) {
			return false;
		}
		if (!pieceCanMove(placex, placey, newplacex, newplacey, chessboard, movecolor, movecount)) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unused")
	private static boolean checkForTakenSpace(int placex, int placey, int newplacex, int newplacey,
			String[][] chessboard, String movecolor, String[][] takenSpace) {
		String taken = chessboard[newplacex][newplacey].substring(1, 2);
		String color = chessboard[newplacex][newplacey].substring(0, 1);

		// Check for taken space
		if (taken == "o") {

			return true;
		} else if (color != movecolor) {

			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings({ "null", "unused" })
	private static void checkForPieceKill(int placex, int placey, int newplacex, int newplacey, String[][] chessboard,
			String movecolor) {
		int k, l;
		String[][] ts = null;

		for (k = 0; k <= 8; k++) {
			for (l = 0; l <= 8; l++) {
				String taken = chessboard[k][l].substring(0, 1);
				if (taken != "o") {
					ts[k][l] = "t";
				} else if (taken == "o") {
					ts[k][l] = chessboard[k][l];
				}
			}
		}

		String[] killedPieces = null;

		if (ts[newplacex][newplacey] == "t" && !(chessboard[newplacex][newplacey].substring(0, 1).equals(movecolor))) {
			killedPieces[i] = chessboard[placex][placey];
			i++;
		}
	}

	private static boolean pieceCanMove(int placex, int placey, int newplacex, int newplacey, String[][] chessboard,
			String movecolor, int movecount) {
		String piece = chessboard[placex][placey].substring(1, 2);
		String color = chessboard[placex][placey].substring(0, 1);

		if (color.equals("w")) {
			if (piece.equals("p")) {
				boolean pawnValid = pawnCheck(placex, placey, newplacex, newplacey, chessboard, movecount, movecolor);
				if (pawnValid == true) {
					return true;
				}
				if (pawnValid == false) {
					System.out.println("Your pawn is not moving correctly");
					return false;
				}
			}
			if (piece.equals("b")) {
				boolean bishopValid = bishopCheck(placex, placey, newplacex, newplacey, chessboard, movecount,
						takenSpaces(placex, placey, newplacex, newplacey, chessboard, movecolor));
				if (bishopValid == true) {
					return true;
				}
				if (bishopValid == false) {
					System.out.println("Your bishop is not moving correctly");
					return false;
				}
			}
			if (piece.equals("k")) {
				boolean kingValid = kingCheck(placex, placey, newplacex, newplacey, chessboard);
				if (kingValid == true) {
					return true;
				}
				if (kingValid == false) {
					System.out.println("Your king is not moving correctly");
					return false;
				}
			}
		}
		if (color.equals("b")) {
			if (piece.equals("p")) {
				boolean pawnValid = pawnCheck(placex, placey, newplacex, newplacey, chessboard, movecount, movecolor);
				if (pawnValid == true) {
					return true;
				}
				if (pawnValid == false) {
					System.out.println("Your pawn is not moving correctly");
					return false;
				}
			}
			if (piece.equals("b")) {
				boolean bishopValid = bishopCheck(placex, placey, newplacex, newplacey, chessboard, movecount,
						takenSpaces(placex, placey, newplacex, newplacey, chessboard, movecolor));
				if (bishopValid == true) {
					return true;
				}
				if (bishopValid == false) {
					System.out.println("Your bishop is not moving correctly");
					return false;
				}
			}
			if (piece.equals("k")) {
				boolean kingValid = kingCheck(placex, placey, newplacex, newplacey, chessboard);
				if (kingValid == true) {
					return true;
				}
				if (kingValid == false) {
					System.out.println("Your king is not moving correctly");
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isPathBlocked(int placex, int placey, int newplacex, int newplacey, String[][] chessboard,
			int movecount, String[][] takenSpace) {

		int a = newplacex - placex;
		int b = newplacey - placey;
		int pathLength = a;

		for (int i = 1; i <= pathLength; i++) {
			if (a > 1 && b > 1 && a < 8 && b < 8) {
				if (takenSpace[newplacex][newplacey] == "t") {
					System.out.println("Error there are pieces between the old place and the new place");
					return true;
				}
				a--;
				b--;
			}
		}
		return false;
	}

	private static boolean pawnCheck(int placey, int placex, int newplacey, int newplacex, String[][] chessboard,
			int movecount, String movecolor) {
		if (movecolor == "w") {
			if (newplacex == placex && placey == newplacey + 1) {
				return true;
			}
			if (newplacex == placex && placey == newplacey + 2) {
				if (placey == 6) {
					return true;
				}
			}
			if (newplacex == placex + 1 && newplacey == placey - 1) {
				if (chessboard[newplacex - 1][placey + 1].substring(0, 1) == "b") {
					return true;
				}
			}
			if (newplacex == placex - 1 && newplacey == placey - 1) {
				if (chessboard[newplacex - 1][placey + 1].substring(0, 1) == "b") {
					return true;
				}
			}
		}
		if (movecolor == "b") {
			if (placex == newplacex) {
				if (placex == newplacex && newplacey == placey + 1) {
					return true;
				}
				if (newplacex == placex && newplacey == placey + 2) {
					if (placey == 1) {
						return true;
					}
				}
			}
			if (placex == newplacex + 1 && placey == newplacey + 1) {
				if (chessboard[newplacex - 1][placey + 1].substring(0, 1) == "w") {
					return true;
				}
			}
			if (placex == newplacex - 1 && placey == newplacey + 1) {
				if (chessboard[newplacex - 1][placey + 1].substring(0, 1) == "w") {
					return true;
				}
			}
		}
		System.out.println("Newplacex = " + newplacex);
		System.out.println("Newplacey = " + newplacey);
		System.out.println("placex = " + placex);
		System.out.println("placey = " + placey);
		return false;
	}

	private static boolean bishopCheck(int placex, int placey, int newplacex, int newplacey, String[][] chessboard,
			int movecount, String[][] takenSpace) {
		boolean isPathBlocked = isPathBlocked(placex, placey, newplacex, newplacey, chessboard, movecount, takenSpace);

		if (newplacex == placex + 1 && newplacey == placey + 1 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 1 && newplacey == placey - 1 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 1 && newplacey == placey + 1 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 1 && newplacey == placey - 1 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 2 && newplacey == placey + 2 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 2 && newplacey == placey - 2 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 2 && newplacey == placey + 2 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 2 && newplacey == placey - 2 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 3 && newplacey == placey + 3 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 3 && newplacey == placey - 3 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 3 && newplacey == placey + 3 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 3 && newplacey == placey - 3 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 4 && newplacey == placey + 4 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 4 && newplacey == placey - 4 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 4 && newplacey == placey + 4 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 4 && newplacey == placey - 4 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 5 && newplacey == placey - 5 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 5 && newplacey == placey + 5 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 5 && newplacey == placey + 5 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 5 && newplacey == placey - 5 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 6 && newplacey == placey + 6 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 6 && newplacey == placey - 6 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 6 && newplacey == placey + 6 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 6 && newplacey == placey - 6 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 7 && newplacey == placey + 7 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 7 && newplacey == placey - 7 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 7 && newplacey == placey + 7 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 7 && newplacey == placey - 7 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 8 && newplacey == placey + 8 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 8 && newplacey == placey - 8 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex - 8 && newplacey == placey + 8 && isPathBlocked == false) {
			movecount++;
			return true;
		} else if (newplacex == placex + 8 && newplacey == placey - 8 && isPathBlocked == false) {
			movecount++;
			return true;
		} else {
			System.out.println("Your bishop is not moving ");
			return false;
		}
	}

	public static boolean kingCheck(int placex, int placey, int newplacex, int newplacey, String[][] chessboard) {
		if (placex == newplacex && placey == newplacey + 1) {
			return true;
			// up
		}
		if (placex == newplacex + 1 && placey == newplacey) {
			return true;
			// left
		}
		if (placex == newplacex - 1 && placey == newplacey) {
			return true;
			// right
		}
		if (placex == newplacex && placey == newplacey - 1) {
			return true;
			// down
		}
		if (placex == newplacex - 1 && placey == newplacey - 1) {
			return true;
			// down right
		}
		if (placex == newplacex + 1 && placey == newplacey - 1) {
			return true;
			// down left
		}
		if (placex == newplacex + 1 && placey == newplacey + 1) {
			return true;
			// up left
		}
		if (placex == newplacex - 1 && placey == newplacey + 1) {
			return true;
			// up right
		}
		return false;
	}

	private static boolean sameColorPiece(int placex, int placey, int newplacex, int newplacey, String[][] chessboard,
			String movecolor) {
		int a = newplacex - placex;
		int b = newplacey - placey;

		if (a < 0) {
			a = -a;
		}
		if (b < 0) {
			b = -b;
		}
		if (a == 0 && b == 0) {
			System.out.println("Your piece is not moving");
			return true;
		}
		if (chessboard[placex][placey] == "o ") {
			System.out.println("There is no piece there");
			System.out.println("placex = " + placex);
			System.out.println("placey = " + placey);
			return true;
		}
		if (chessboard[newplacex][newplacey].substring(0, 1).equals(movecolor)) {
			return false;
		}
		if (chessboard[newplacex][newplacey].substring(0, 1).equals("o")) {
			return false;
		}
		if (!(chessboard[placex][placey].substring(0, 1).equals(movecolor))) {
			System.out.println("Wrong color");
			System.out.println(chessboard[placex][placey].substring(0, 1) + " is not equal to " + movecolor);
			System.out.println("placex = " + placex);
			System.out.println("placey = " + placey);
			return true;
		}

		System.out.println("" + newplacex + newplacey);
		System.out.println("" + placex + placey);
		return true;
	}

	private static boolean inBounds(int newplacex, int newplacey, String[][] chessboard) {
		try {
			chessboard[newplacex][newplacey] = chessboard[newplacex][newplacey];
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private static String[][] takenSpaces(int placex, int placey, int newplacex, int newplacey, String[][] chessboard,
			String movecolor) {
		int k, l;
		String[][] takenSpace = new String[8][8];

		for (k = 0; k < 8; k++) {
			for (l = 0; l < 8; l++) {
				String taken = chessboard[k][l].substring(0, 1);
				if (taken != "o") {
					takenSpace[k][l] = "t";
				} else if (taken == "o") {
					takenSpace[k][l] = chessboard[k][l];
				}
			}
		}
		return takenSpace;
	}

	private static String[][] newboard(String[][] chessboard) {
		chessboard[0][0] = "br";
		chessboard[0][1] = "bn";
		chessboard[0][2] = "bb";
		chessboard[0][3] = "bq";
		chessboard[0][4] = "bk";
		chessboard[0][5] = "bb";
		chessboard[0][6] = "bn";
		chessboard[0][7] = "br";
		for (int x = 0; x < 8; x++) {
			chessboard[1][x] = "bp";
		}
		for (int y = 2; y < 6; y++) {
			for (int x = 0; x < 8; x++) {
				chessboard[y][x] = "o ";
			}
		}
		chessboard[7][0] = "wr";
		chessboard[7][1] = "wn";
		chessboard[7][2] = "wb";
		chessboard[7][3] = "wq";
		chessboard[7][4] = "wk";
		chessboard[7][5] = "wb";
		chessboard[7][6] = "wn";
		chessboard[7][7] = "wr";
		for (int x = 0; x < 8; x++) {
			chessboard[6][x] = "wp";
		}
		return chessboard;
	}

	public static void printboard(String[][] chessboard) {
		System.out.println("__________________________");
		for (int x = 0; x < 8; x++) {
			System.out.print("|");
			for (int y = 0; y < 8; y++) {
				System.out.print(chessboard[x][y] + " ");
			}
			System.out.println("|");
		}
		System.out.println("__________________________");
	}
}
