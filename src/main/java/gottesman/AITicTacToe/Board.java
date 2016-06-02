package gottesman.AITicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {
	// figure out all positions to get best move
	// goal of AI- figure out best move based on current information
	public enum Piece {
		X, O, EMPTY;
		public Piece otherPlayer() {
			return this == Piece.X ? Piece.O : Piece.X;
		}
	}

	private Piece array[] = new Piece[9];
	private Piece activePlayer = Piece.X;

	public Board(Board other) {
		array = other.array.clone();
		activePlayer = other.activePlayer.otherPlayer();
	}

	public Board() {
		for (int i = 0; i < array.length; i++) {
			array[i] = Piece.EMPTY;
		}
	}

	public Piece getWinner() {
		if (getWinner(0, 1, 2)) {
			return array[0];
		}
		if (getWinner(3, 4, 5)) {
			return array[3];
		}

		if (getWinner(6, 7, 8)) {
			return array[6];
		}
		if (getWinner(0, 3, 6)) {
			return array[0];
		}
		if (getWinner(1, 4, 7)) {
			return array[1];
		}
		if (getWinner(2, 5, 8)) {
			return array[2];
		}
		if (getWinner(0, 4, 8)) {
			return array[0];
		}
		if (getWinner(2, 4, 6)) {
			return array[2];
		}
		return null;
	}

	public boolean getWinner(int a, int b, int c) {
		return array[a] != Piece.EMPTY && array[a] == array[b] && array[b] == array[c];
	}

	public void set(int index, Piece piece) {
		array[index] = piece;
	}

	public Piece get(int index) {
		return array[index];
	}

	// return list of all possible moves
	public List<Integer> getMoves() {
		List<Integer> possibleMoves = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(Piece.EMPTY)) {
				possibleMoves.add(i);
			}
		}
		return possibleMoves;
	}

	public boolean gameOver() {
		if (getWinner() == null) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] == Piece.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	public Piece getActivePlayer() {
		return activePlayer;
	}

	public void switchPlayer(Piece piece) {
		activePlayer = piece;
	}

	@Override
	public String toString() {
		return array[0].name() + array[1].name() + array[2].name() + "\n" + array[3].name() + array[4].name()
				+ array[5].name() + "\n" + array[6].name() + array[7].name() + array[8].name();
	}
}