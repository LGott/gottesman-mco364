package gottesman.AITicTacToe;

import java.util.List;
import java.util.Stack;

import gottesman.AITicTacToe.Board.Piece;

public class EnumerateBoards {
	/**
	 * 
	 * determine the number of possible boards and which piece wins more often,
	 * 
	 * X or O. Find how many time each piece wins.
	 * 
	 */
	public static void main(String[] args) {
		Stack<Board> stack = new Stack<Board>();
		Board board;
		int bCounter = 0;
		int xWin = 0;
		int oWin = 0;
		int ties = 0;

		Board emptyBoard = new Board();
		stack.push(emptyBoard);
		while (!stack.isEmpty()) {
			Board b = stack.pop();
			bCounter++;
			Piece winner = b.getWinner();
			if (winner == Piece.X) {
				xWin++;
				continue;
			} else if (winner == Piece.O) {
				oWin++;
				continue;
			} else if (b.gameOver()) {
				ties++;
			}

			Board.Piece activePlayer = b.getActivePlayer();
			List<Integer> moves = b.getMoves();
			for (int move : moves) {
				Board child = new Board(b);
				child.set(move, activePlayer);
				stack.push(child);
			}
		}
		System.out.printf("number of boards =%d, x wins =%d, o wins =%d, ties = %d", bCounter, xWin, oWin, ties);
	}
}