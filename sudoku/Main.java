package sudoku;

import java.util.Scanner;

public class Main {

    static class Board {
        private int[][] board;
        private boolean everySquareFilled = false;

		public Board(int[][] board) {
			this.board = board;
		}

        // You can add methods like isValidMove(), printBoard(), etc.
	public class PrintBoard(board){
			for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
		public class checkIfSolved(board){
			if (everySquareFilled){
			int rowSum = 0;
			int columnSum = 0;
			int blockSunm = 0;
			for (int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
					rowSum = rowSum + board[i][j];
					}
				}
			for (int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
					columnSum = columnSum + board[i][j];
					}
				}
					for (int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
					blockSum = blockSum + board[i][j];
					}
				}
			}
			
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board sudokuBoard = new Board();

        boolean solved = false;

        while (!solved) {
            System.out.print("Enter row (0-8): ");
            int row = getValidInt(sc);

            System.out.print("Enter column (0-8): ");
            int col = getValidInt(sc);

            System.out.print("Enter value (1-9): ");
            int value = getValidInt(sc);

            if (value < 1 || value > 9) {
                System.out.println("Enter integer between 1 to 9");
                continue;
            }

            sudokuBoard.board[row][col] = value;

            // Add logic to check if board is solved
            // solved = checkIfSolved(sudokuBoard);
        }

        sc.close();
    }

    private static int getValidInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Enter an integer:");
            sc.next(); // discard invalid input
        }
        return sc.nextInt();
    }
}
