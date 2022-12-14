/**************************************************************
 * A simple two player Tic Tac Toe game played on the terminal.
 **************************************************************/

import java.util.Scanner;

class TTTv0
{
	/** 
	 * Initiates and controls a game.
	 */
	public static void play()
	{
		char[][] board = {
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', ' '} 
			};
		int turn = 0;
		
		while (turn != 8) {
			char player = ' ';

			if (turn%2 == 0) {
				player = 'X';
			} else {
				player = 'O';
			}

			printBoard(board);

			place(board, player);

			if (checkWin(board, player) != ' ') {
				System.out.println();
				printBoard(board);
				System.out.println(player + " wins!");
				break;
			}
			turn++;
		}
	}

	/**
	 * Places X's and O's on the board
	 */
	public static void place(char[][] board, char player)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Where would you like to play? [1-9]");
		String userInput = scanner.nextLine();

		switch(userInput) {
		case "1":
			if (board[0][0] == ' ') {
				board[0][0] = player;
			} else {
				placeError(board, player);
			}
			break;
		case "2":
			if (board[0][1] == ' ') {
				board[0][1] = player;
			} else {
				placeError(board, player);
			}
			break;
		case "3":
			if (board[0][2] == ' ') {
				board[0][2] = player;
			} else {
				placeError(board, player);
			}
			break;
		case "4":
			if (board[1][0] == ' ') {
				board[1][0] = player;
			} else {
				placeError(board, player);
			}
			break;
		case "5":
			if (board[1][1] == ' ') {
				board[1][1] = player;
			} else {
				placeError(board, player);
			}
			break;
		case "6":
			if (board[1][2] == ' ') {
				board[1][2] = player;
			} else {
				placeError(board, player);
			}
			break;
		case "7":
			if (board[2][0] == ' ') {
				board[2][0] = player;
			} else {
				placeError(board, player);
			}
			break;
		case "8":
			if (board[2][1] == ' ') {
				board[2][1] = player;
			} else {
				placeError(board, player);
			}
			break;
		case "9":
			if (board[2][2] == ' ') {
				board[2][2] = player;
			} else {
				placeError(board, player);
			}
			break;
		default:
			placeError(board, player);
			break;
		}
	}

	/**
	 * Calls place in case of error in attempted placement
	 */
	public static void placeError(char[][] board, char player)
	{
		System.out.println("Invalid position. Please choose again.");
		place(board, player);
	}
	
	/**
	 * Prints the board
	 */
	public static void printBoard(char[][] board)
	{
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
	}

	/**
	 * Checks to see if a player has won
	 */	
	public static char checkWin(char[][] board, char player)
	{
		char winner = ' ';

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] != player) {
					break;
				} else if (col == 2) {
					return winner = player;
				} else {
					continue;
				}
			}
		}
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				if (board[row][col] != player) {
					break;
				} else if (row == 2) {
					return winner = player;
				} else {
					continue;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (board[i][i] != player) {
				break;
			} else if (i == 2) {
				return winner = player;
			} else {
				continue;
			}
		}
		for (int j = 0; j < 3; j++) {
			if (board[j][2-j] != player) {
				break;
			} else if (j == 2) {
				return winner = player;
			} else {
				continue;
			}
		}

		return winner;
	}

	/**
	 * Tester
	 */
	public static void main(String[] args)
	{
		play();
	}
}